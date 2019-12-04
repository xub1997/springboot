package com.xub.shiro.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSysPermission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限编号
     */
    private String id;

    /**
     * 权限名称
     */
    private String permissionName;

    /**
     * 权限描述
     */
    private String permissionDesc;

    /**
     * 权限类型（1 菜单  2 按钮 ）
     */
    private Integer permissionType;

    /**
     * 权限编码
     */
    private String permissionCode;

    /**
     * url链接
     */
    private String permissionUrl;

    /**
     * 请求方式（1 POST  2 GET  3 PUT 4 DELETE）
     */
    private Integer requestMethod;

    /**
     * 排序（1 最高，往上排序越低）
     */
    private Integer sort;

    /**
     * 父级id(0表示没有父级)
     */
    private String pid;

    /**
     * 是否启用（0 未启用 1已启用）
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
    private Date createTime;

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
    private Date updateTime;

    /**
     * 更新程序
     */
    private String updateProgram;


}
