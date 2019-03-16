package com.xub.wechat.controller;

import com.xub.wechat.service.MyFriendsService;
import com.xub.wechat.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MyFriendsController
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/11.23:43
 **/
@RestController
public class MyFriendsController {

    @Autowired
    private MyFriendsService myFriendsService;

    /**
     * @Description: 查询我的好友列表
     */
    @GetMapping("/myFriends")
    public ResponseData queryMyFriends(@RequestParam("userid")String userid){
        return myFriendsService.queryMyFriends(userid);
    }

}
