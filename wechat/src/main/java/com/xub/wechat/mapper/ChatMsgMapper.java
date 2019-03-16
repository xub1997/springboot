package com.xub.wechat.mapper;

import com.xub.wechat.pojo.ChatMsg;
import com.xub.wechat.utils.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ChatMsgMapper extends MyMapper<ChatMsg> {

    void batchUpdateMsgSigned(List<String> msgIdList);
}