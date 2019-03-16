package com.xub.wechat.mapper;

import com.xub.wechat.pojo.FriendRequest;
import com.xub.wechat.pojo.vo.FriendRequestVO;
import com.xub.wechat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FriendRequestMapper extends MyMapper<FriendRequest> {
    List<FriendRequestVO> getFriendRequestList(String userid);
}