package com.xub.shiro.core.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 用户信息表
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户编号
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 昵称
     */
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
    private Integer isUsed;

    /**
     * 是否删除（0 未删除  1 已删除）
     */
    private Integer isDeleted;

    /**
     * 创建人id
     */
    private String creatorId;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 创建程序
     */
    private String createProgram;

    /**
     * 更新人id
     */
    private String updaterId;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 更新程序
     */
    private String updateProgram;


}
