package com.xub.wechat.enums;

/**
 * 
 * @Description: 添加好友前置状态 枚举
 */
public enum SearchFriendsStatusEnum {
	
	SUCCESS(0, "成功"),
	USER_NOT_EXIST(1, "无此用户..."),	
	NOT_YOURSELF(2, "不能添加你自己..."),			
	ALREADY_FRIENDS(3, "该用户已经是你的好友...");
	
	public final Integer code;
	public final String msg;
	
	SearchFriendsStatusEnum(Integer code, String msg){
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public static String getMsgByKey(Integer code) {
		for (SearchFriendsStatusEnum type : SearchFriendsStatusEnum.values()) {
			if (type.getCode() == code) {
				return type.msg;
			}
		}
		return null;
	}
	
}
