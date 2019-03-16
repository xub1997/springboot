package com.xub.wechat.pojo;

import javax.persistence.*;

@Table(name = "tb_my_friends")
public class MyFriends {
    /**
     * 朋友关系编号
     */
    @Id
    @Column(name = "friendship_id")
    private String friendshipId;

    /**
     * 我的用户编号
     */
    @Column(name = "mine_id")
    private String mineId;

    /**
     * 朋友的用户编号
     */
    @Column(name = "friend_id")
    private String friendId;

    /**
     * 是否删除（0未删除  1已删除）
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 获取朋友关系编号
     *
     * @return friendship_id - 朋友关系编号
     */
    public String getFriendshipId() {
        return friendshipId;
    }

    /**
     * 设置朋友关系编号
     *
     * @param friendshipId 朋友关系编号
     */
    public void setFriendshipId(String friendshipId) {
        this.friendshipId = friendshipId;
    }

    /**
     * 获取我的用户编号
     *
     * @return mine_id - 我的用户编号
     */
    public String getMineId() {
        return mineId;
    }

    /**
     * 设置我的用户编号
     *
     * @param mineId 我的用户编号
     */
    public void setMineId(String mineId) {
        this.mineId = mineId;
    }

    /**
     * 获取朋友的用户编号
     *
     * @return friend_id - 朋友的用户编号
     */
    public String getFriendId() {
        return friendId;
    }

    /**
     * 设置朋友的用户编号
     *
     * @param friendId 朋友的用户编号
     */
    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    /**
     * 获取是否删除（0未删除  1已删除）
     *
     * @return is_del - 是否删除（0未删除  1已删除）
     */
    public Integer getIsDel() {
        return isDel;
    }

    /**
     * 设置是否删除（0未删除  1已删除）
     *
     * @param isDel 是否删除（0未删除  1已删除）
     */
    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }
}