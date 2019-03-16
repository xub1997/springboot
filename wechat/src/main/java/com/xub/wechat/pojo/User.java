package com.xub.wechat.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import javax.persistence.*;

@Table(name = "tb_user")
public class User {
    /**
     * 用户编号
     */
    @Id
    private String userid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 盐值
     */
    @JsonIgnore
    private String salt;

    /**
     * 密码
     */
    @JsonIgnore
    private String pwd;

    /**
     * 状态（1正常  2锁定  3注销  ）
     */
    private Integer status;

    /**
     * 二维码
     */
    private String qrcode;

    /**
     * 小头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 大头像
     */
    @Column(name = "avatar_url_big")
    private String avatarUrlBig;

    /**
     * 手机唯一标示
     */
    private String cid;

    /**
     * 国家
     */
    private String country;

    /**
     * 地区
     */
    private String region;

    /**
     * 城市
     */
    private String city;

    /**
     * 是否删除（0未删除  1已删除）
     */
    @Column(name = "is_del")
    private Integer isDel;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取用户编号
     *
     * @return userid - 用户编号
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户编号
     *
     * @param userid 用户编号
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取盐值
     *
     * @return salt - 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐值
     *
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取状态（1正常  2锁定  3注销  ）
     *
     * @return status - 状态（1正常  2锁定  3注销  ）
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态（1正常  2锁定  3注销  ）
     *
     * @param status 状态（1正常  2锁定  3注销  ）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取二维码
     *
     * @return qrcode - 二维码
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置二维码
     *
     * @param qrcode 二维码
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 获取小头像
     *
     * @return avatar_url - 小头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置小头像
     *
     * @param avatarUrl 小头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取大头像
     *
     * @return avatar_url_big - 大头像
     */
    public String getAvatarUrlBig() {
        return avatarUrlBig;
    }

    /**
     * 设置大头像
     *
     * @param avatarUrlBig 大头像
     */
    public void setAvatarUrlBig(String avatarUrlBig) {
        this.avatarUrlBig = avatarUrlBig;
    }

    /**
     * 获取手机唯一标示
     *
     * @return cid - 手机唯一标示
     */
    public String getCid() {
        return cid;
    }

    /**
     * 设置手机唯一标示
     *
     * @param cid 手机唯一标示
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * 获取国家
     *
     * @return country - 国家
     */
    public String getCountry() {
        return country;
    }

    /**
     * 设置国家
     *
     * @param country 国家
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 获取地区
     *
     * @return region - 地区
     */
    public String getRegion() {
        return region;
    }

    /**
     * 设置地区
     *
     * @param region 地区
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
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

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}