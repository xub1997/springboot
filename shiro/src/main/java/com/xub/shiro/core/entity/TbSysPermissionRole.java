package com.xub.shiro.core.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TbSysPermissionRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 权限编号
     */
    private String permissionId;

    /**
     * 角色编号
     */
    private String roleId;


}
