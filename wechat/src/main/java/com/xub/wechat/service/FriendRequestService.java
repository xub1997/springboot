package com.xub.wechat.service;

import com.xub.wechat.pojo.FriendRequest;
import com.xub.wechat.pojo.vo.FriendRequestVO;
import com.xub.wechat.utils.ResponseData;


public interface FriendRequestService {

    /*
    * 添加好友请求记录，保存到数据库
    * */
    ResponseData sendFriendRequest(FriendRequest friendRequest);


    /*
    * 获取好友请求列表
    * */
    ResponseData  getFriendRequestList(String acceptUserId);


    /*
    * 操作好友请求
    * */
    ResponseData operatorFriendRequest(String acceptUserId,String sendUserId,Integer operType);
}
