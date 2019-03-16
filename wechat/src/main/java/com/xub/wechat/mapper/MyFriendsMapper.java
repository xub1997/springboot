package com.xub.wechat.mapper;

import com.xub.wechat.pojo.MyFriends;
import com.xub.wechat.pojo.vo.MyFriendsVO;
import com.xub.wechat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MyFriendsMapper extends MyMapper<MyFriends> {
    List<MyFriendsVO> queryMyFriends(String userid);
}