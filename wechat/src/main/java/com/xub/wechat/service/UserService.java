package com.xub.wechat.service;


import com.xub.wechat.pojo.User;
import com.xub.wechat.utils.ResponseData;

import javax.servlet.http.HttpServletRequest;


public interface UserService {

    /**
     * @Description: 用户注册
     */
    ResponseData register(User user, HttpServletRequest request);

    /**
     * @Description: 用户登录
     */
    ResponseData login(String username, String pwd);


    /**
     * @Description: 查询用户是否存在
     */
    boolean queryUsernameIsExist(String username);


    /**
     * @Description: 修改用户记录
     */
    User updateUserInfo(User user);

    /**
     * @Description: 根据id查询用户记录
     */
    User queryUserById(String userId);


    /**
     * @Description: 根据id更新用户记录
     */
    ResponseData upadteUserById(User user);


    /**
     * @Description: 查询用户记录（模糊查询）
     */
    ResponseData search(String username);


    /*
    * 根据用户名查询用户对象   查找（添加朋友）
    * */
    User queryUserInfoByUsername(String username);


    /**
     * @Description: 搜索朋友的前置条件
     */
    Integer preConditionSearchFriend(String myUserid,String friendUsername);
}
