package com.xub.security.core.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
public class TbSysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 角色编号
     */
    private String roleId;


}
