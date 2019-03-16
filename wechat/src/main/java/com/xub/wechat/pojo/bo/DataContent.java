package com.xub.wechat.pojo.bo;

import com.xub.wechat.pojo.vo.ChatMsgVO;

import java.io.Serializable;

public class DataContent implements Serializable {

	private static final long serialVersionUID = 8021381444738260454L;

	private Integer action;		// 动作类型
	private ChatMsgVO chatMsgVO;	// 用户的聊天内容entity
	private String extend;		// 扩展字段


	public Integer getAction() {
		return action;
	}

	public void setAction(Integer action) {
		this.action = action;
	}

	public ChatMsgVO getChatMsgVO() {
		return chatMsgVO;
	}

	public void setChatMsgVO(ChatMsgVO chatMsgVO) {
		this.chatMsgVO = chatMsgVO;
	}

	public String getExtend() {
		return extend;
	}

	public void setExtend(String extend) {
		this.extend = extend;
	}
}
