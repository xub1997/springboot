package com.xub.wechat.service;

import com.xub.wechat.utils.ResponseData;

public interface MyFriendsService {
    /**
     * @Description: 查询我的好友列表
     */
    ResponseData queryMyFriends(String userid);
}
