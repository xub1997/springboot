package com.xub.jpa.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tb_user")
@EqualsAndHashCode
public class TbUserPO {
    /**
     * 用户编号
     */
    @Id
    private String id;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 密码
     */
    private String pwd;

    /**
     * openId
     */
    @Column(name = "open_id")
    private String openId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 性别（0	未知 1男  2女）
     */
    private Integer gender;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 国家
     */
    private String country;

    /**
     * 省份
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址
     */
    private String address;

    /**
     * Email
     */
    private String email;

    /**
     * 是否使用（1 正常使用  2禁用  3停止使用）
     */
    @Column(name = "is_used")
    private Byte isUsed;

    /**
     * 是否删除（0 未删除  1 已删除）
     */
    @Column(name = "is_deleted")
    private Byte isDeleted;

    /**
     * 创建人id
     */
    @Column(name = "creator_id")
    private String creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 创建程序
     */
    @Column(name = "create_program")
    private String createProgram;

    /**
     * 更新人id
     */
    @Column(name = "updater_id")
    private String updaterId;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 更新程序
     */
    @Column(name = "update_program")
    private String updateProgram;

    /**
     * 获取用户编号
     *
     * @return id - 用户编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置用户编号
     *
     * @param id 用户编号
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取昵称
     *
     * @return nick_name - 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 设置昵称
     *
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * 获取openId
     *
     * @return open_id - openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 设置openId
     *
     * @param openId openId
     */
    public void setOpenId(String openId) {
        this.openId = openId;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取性别（0	未知 1男  2女）
     *
     * @return gender - 性别（0	未知 1男  2女）
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别（0	未知 1男  2女）
     *
     * @param gender 性别（0	未知 1男  2女）
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
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
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
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
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取Email
     *
     * @return email - Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置Email
     *
     * @param email Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取是否使用（1 正常使用  2禁用  3停止使用）
     *
     * @return is_used - 是否使用（1 正常使用  2禁用  3停止使用）
     */
    public Byte getIsUsed() {
        return isUsed;
    }

    /**
     * 设置是否使用（1 正常使用  2禁用  3停止使用）
     *
     * @param isUsed 是否使用（1 正常使用  2禁用  3停止使用）
     */
    public void setIsUsed(Byte isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * 获取是否删除（0 未删除  1 已删除）
     *
     * @return is_deleted - 是否删除（0 未删除  1 已删除）
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置是否删除（0 未删除  1 已删除）
     *
     * @param isDeleted 是否删除（0 未删除  1 已删除）
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取创建人id
     *
     * @return creator_id - 创建人id
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 设置创建人id
     *
     * @param creatorId 创建人id
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 获取创建人
     *
     * @return creator - 创建人
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建人
     *
     * @param creator 创建人
     */
    public void setCreator(String creator) {
        this.creator = creator;
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
     * 获取创建程序
     *
     * @return create_program - 创建程序
     */
    public String getCreateProgram() {
        return createProgram;
    }

    /**
     * 设置创建程序
     *
     * @param createProgram 创建程序
     */
    public void setCreateProgram(String createProgram) {
        this.createProgram = createProgram;
    }

    /**
     * 获取更新人id
     *
     * @return updater_id - 更新人id
     */
    public String getUpdaterId() {
        return updaterId;
    }

    /**
     * 设置更新人id
     *
     * @param updaterId 更新人id
     */
    public void setUpdaterId(String updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 获取更新人
     *
     * @return updater - 更新人
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * 设置更新人
     *
     * @param updater 更新人
     */
    public void setUpdater(String updater) {
        this.updater = updater;
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

    /**
     * 获取更新程序
     *
     * @return update_program - 更新程序
     */
    public String getUpdateProgram() {
        return updateProgram;
    }

    /**
     * 设置更新程序
     *
     * @param updateProgram 更新程序
     */
    public void setUpdateProgram(String updateProgram) {
        this.updateProgram = updateProgram;
    }
}
