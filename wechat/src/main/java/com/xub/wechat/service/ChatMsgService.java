package com.xub.wechat.service;



import com.xub.wechat.pojo.ChatMsg;
import com.xub.wechat.pojo.vo.ChatMsgVO;

import java.util.List;

public interface ChatMsgService {

    /**
     * @Description: 保存聊天消息到数据库
     */
    String saveMsg(ChatMsgVO chatMsg);

    /**
     * @Description: 批量签收消息
     */
    void updateMsgSigned(List<String> msgIdList);


    /**
     * @Description: 获取未签收消息列表
     */
    List<ChatMsg> getUnReadMsgList(String acceptUserId);
}
