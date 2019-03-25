package com.xub.wechat.push;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.xub.wechat.config.PushConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppPush {
    private static Logger logger= LoggerFactory.getLogger(AppPush.class);

    /*
    * 给单个用户发推送（通知形式：点击通知打开应用模板）
    * */
    public static void pushToSingleWithNotificationTemplate(PushConfig pushConfig,String title,String msg,String CID){
        /*
        * 获取配置文件的参数
        * */
        String host=pushConfig.getHost();
        String appKey=pushConfig.getAppKey();
        String masterSecret=pushConfig.getMasterSecret();
        String appId=pushConfig.getAppId();

        //声明推送对象
        IGtPush push = new IGtPush(host, appKey,masterSecret );
        //创建推送模板
        NotificationTemplate template=notificationTemplateDemo(appId,appKey,"",title,msg);


        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(CID);
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            logger.info(ret.getResponse().toString());
        } else {
            logger.info("服务器响应异常");
        }
    }

    /*
     *点击通知打开应用模板
     * */
    private static NotificationTemplate notificationTemplateDemo(
            String appId, String appkey,String transmissionContent,String title,String msg) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appkey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        template.setTransmissionContent(transmissionContent);
        // 设置定时展示时间
        // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(msg);
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);
        return template;
    }


    /*
    * 链接推送模板
    * */
    private  static LinkTemplate linkTemplateDemo(String appId,String appKey,String title,String msg,String linkUrl) {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();

        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(msg);

        // 配置通知栏图标
        style.setLogo("icon.png");

        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        // 设置打开的网址地址
        template.setUrl(linkUrl);

        return template;
    }


}
