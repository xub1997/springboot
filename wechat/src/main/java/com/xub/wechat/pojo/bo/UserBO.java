package com.xub.wechat.pojo.bo;

/**
 * @ClassName UserBO
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/11.17:25
 **/
public class UserBO {
    private String userid;
    private String avatarData;
    private String nickname;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAvatarData() {
        return avatarData;
    }
    public void setAvatarData(String avatarData) {
        this.avatarData = avatarData;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
