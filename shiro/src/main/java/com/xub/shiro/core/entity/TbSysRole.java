package com.xub.shiro.core.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 角色编号
     */
    private String id;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String roleDesc;

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
