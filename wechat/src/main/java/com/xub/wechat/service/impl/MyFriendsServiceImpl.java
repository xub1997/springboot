package com.xub.wechat.service.impl;

import com.xub.wechat.mapper.MyFriendsMapper;
import com.xub.wechat.pojo.vo.MyFriendsVO;
import com.xub.wechat.service.MyFriendsService;
import com.xub.wechat.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName MyFriendsServiceImpl
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/12.10:44
 **/
@Service("myFriendsService")
public class MyFriendsServiceImpl implements MyFriendsService {

    @Autowired
    private MyFriendsMapper myFriendsMapper;


    @Override
    public ResponseData queryMyFriends(String userid) {
        List<MyFriendsVO> myFriendsVOS=myFriendsMapper.queryMyFriends(userid);
        if(myFriendsVOS.size()>0){
            return ResponseData.ok("获取通讯录成功").putDataValue("myFriends",myFriendsVOS);
        }
        return ResponseData.error("获取数据为空");
    }
}
