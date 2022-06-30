package com.xub.springboot.study.mapstruct.pojo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xub.springboot.study.mapstruct.enums.SexEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author liqingxu
 * @Description
 * @create 2022-06-30
 */
@Data
@Accessors(chain = true)
public class User {

    /**
     * id
     */
    private String id;

    /**
     * 登录账号
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 密码
     */
    private String password;

    /**
     * md5密码盐
     */
    private String salt;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 生日
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 性别（1：男 2：女）
     */
    private SexEnum sex;

    /**
     * 电子邮箱
     */
    private String email;

    /**
     * 个人电话
     */
    private String phone;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

}
