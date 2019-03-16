package com.xub.wechat.pojo.vo;

/**
 * @ClassName FriendRequestVO
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/13.12:10
 **/
public class FriendRequestVO {
    private String sendUserId;
    private String sendUsername;
    private String sendAvatarUrl;
    private String sendNickname;

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getSendUsername() {
        return sendUsername;
    }

    public void setSendUsername(String sendUsername) {
        this.sendUsername = sendUsername;
    }

    public String getSendAvatarUrl() {
        return sendAvatarUrl;
    }

    public void setSendAvatarUrl(String sendAvatarUrl) {
        this.sendAvatarUrl = sendAvatarUrl;
    }

    public String getSendNickname() {
        return sendNickname;
    }

    public void setSendNickname(String sendNickname) {
        this.sendNickname = sendNickname;
    }
}
