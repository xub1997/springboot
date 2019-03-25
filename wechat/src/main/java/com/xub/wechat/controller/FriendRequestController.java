package com.xub.wechat.controller;

import com.xub.wechat.config.PushConfig;
import com.xub.wechat.enums.OperatorFriendRequestTypeEnum;
import com.xub.wechat.enums.RequestStatusEnum;
import com.xub.wechat.enums.SearchFriendsStatusEnum;
import com.xub.wechat.pojo.FriendRequest;
import com.xub.wechat.pojo.User;
import com.xub.wechat.push.AppPush;
import com.xub.wechat.service.FriendRequestService;
import com.xub.wechat.service.UserService;
import com.xub.wechat.utils.ResponseData;
import com.xub.wechat.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @ClassName FriendRequestController
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/12.10:41
 **/
@RestController
public class FriendRequestController {


    @Autowired
    private UserService userService;

    @Autowired
    private FriendRequestService friendRequestService;

    @Autowired
    private AppPush appPush;


    @Autowired
    private PushConfig pushConfig;

    /*
     * 搜索好友，根据账号做匹配查询而不是模糊查询,返回账号对应用户信息
     *
     * 前置条件：
     * 1、搜索的用户不存在，返回：无此用户
     * 2、搜索的用户是自己，返回：不能添加自己
     * 3、搜索的用户已经是你的好友，返回：该用户已经是你的好友
     *
     * */
    @GetMapping("/friendRequest")
    public ResponseData queryUserInfoByUsername(@RequestParam("friendUsername")String friendUsername,
                               @RequestParam("myUserid")String myUserid){
        if(StringUtil.isEmpty(friendUsername)||StringUtil.isEmpty(myUserid)){
            return ResponseData.error("请输入用户账号");
        }
        Integer flag=userService.preConditionSearchFriend(myUserid,friendUsername);
        if(flag== SearchFriendsStatusEnum.SUCCESS.code){
            User search_result= userService.queryUserInfoByUsername(friendUsername);
            return ResponseData.ok("查找成功").putDataValue("user",search_result);
        }else{
            String errorMsg=SearchFriendsStatusEnum.getMsgByKey(flag);
            return ResponseData.error(errorMsg);
        }
    }


    /*
     * 发送添加好友请求
     *  * 前置条件：
     * 1、搜索的用户不存在，返回：无此用户
     * 2、搜索的用户是自己，返回：不能添加自己
     * 3、搜索的用户已经是你的好友，返回：该用户已经是你的好友
     * */
    @PostMapping("/friendRequest")
    public ResponseData addFriend(@RequestParam("friendUsername")String friendUsername,
                                  @RequestParam("myUserid")String myUserid){
        if(StringUtil.isEmpty(friendUsername)||StringUtil.isEmpty(myUserid)){
            return ResponseData.error("请输入用户账号");
        }
        Integer flag=userService.preConditionSearchFriend(myUserid,friendUsername);
        if(flag== SearchFriendsStatusEnum.SUCCESS.code){
            User search_result= userService.queryUserInfoByUsername(friendUsername);
            FriendRequest friendRequest=new FriendRequest();
            friendRequest.setSendUserId(myUserid);
            friendRequest.setAcceptUserId(search_result.getUserid());
            friendRequest.setStatus(RequestStatusEnum.Wait_Accept.getCode());//待通过
            friendRequest.setIsDel(0);//未删除
            AppPush.pushToSingleWithNotificationTemplate(pushConfig,"好友请求",friendUsername+"请求添加你为好友",search_result.getCid());
            return friendRequestService.sendFriendRequest(friendRequest);
        }else{
            String errorMsg=SearchFriendsStatusEnum.getMsgByKey(flag);
            return ResponseData.error(errorMsg);
        }
    }

    /*
    * 获取好友请求列表
    * */
    @GetMapping("/friendRequests")
    public ResponseData getFriendRequestList(@RequestParam("userid")String userid){
        if(StringUtil.isEmpty(userid)){
            return ResponseData.error("请输入用户账号");
        }
        return friendRequestService.getFriendRequestList(userid);
    }


    /*
    * 操作好友请求
    * */
    @PutMapping("/operatorFriendRequest")
    public ResponseData operatorFriendRequest(@RequestParam("acceptUserId")String acceptUserId,
                                              @RequestParam("sendUserId")String sendUserId,
                                              @RequestParam("operType")Integer operType){
        if(StringUtil.isEmpty(acceptUserId)||StringUtil.isEmpty(sendUserId)||StringUtil.isEmpty(operType)){
            return ResponseData.error("操作好友请求参数为空");
        }
        if(StringUtil.isEmpty(OperatorFriendRequestTypeEnum.getMsgByType(operType))){
            return ResponseData.error("操作类型错误");
        }
        return friendRequestService.operatorFriendRequest(acceptUserId, sendUserId, operType);
    }

}
