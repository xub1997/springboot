package com.xub.wechat.service.impl;

import com.xub.wechat.enums.MsgSignFlagEnum;
import com.xub.wechat.mapper.ChatMsgMapper;

import com.xub.wechat.pojo.ChatMsg;
import com.xub.wechat.pojo.vo.ChatMsgVO;
import com.xub.wechat.service.ChatMsgService;
import com.xub.wechat.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service("chatMsgService")
public class ChatMsgServiceImpl implements ChatMsgService {

    @Autowired
    private ChatMsgMapper chatMsgMapper;


    /**
     * @Description: 保存聊天消息到数据库
     * @return msgId
     */
    @Override
    public String saveMsg(ChatMsgVO chatMsgVO) {
        ChatMsg msgDB = new ChatMsg();
        String msgId = StringUtil.getRandomString();
        msgDB.setMsgId(msgId);
        msgDB.setAcceptUserid(chatMsgVO.getReceiverId());
        msgDB.setSendUserid(chatMsgVO.getSenderId());
        msgDB.setCreateTime(new Date());
        msgDB.setSignFlag(MsgSignFlagEnum.unsign.type);
        msgDB.setMsg(chatMsgVO.getMsg());
        msgDB.setIsDel(0);
        chatMsgMapper.insert(msgDB);

        return msgId;
    }


    /**
     * @Description: 批量签收消息
     */
    @Override
    public void updateMsgSigned(List<String> msgIdList) {
        chatMsgMapper.batchUpdateMsgSigned(msgIdList);
    }

    /**
     * @Description: 获取未签收消息列表
     */
    @Override
    public List<ChatMsg> getUnReadMsgList(String acceptUserId) {
        Example chatExample = new Example(ChatMsg.class);
        Example.Criteria chatCriteria = chatExample.createCriteria();
        chatCriteria.andEqualTo("signFlag", 0);
        chatCriteria.andEqualTo("acceptUserid", acceptUserId);
        chatCriteria.andEqualTo("isDel", 0);
        List<ChatMsg> result = chatMsgMapper.selectByExample(chatExample);
        return result;
    }
}
