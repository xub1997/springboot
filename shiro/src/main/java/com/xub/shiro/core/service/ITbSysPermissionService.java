package com.xub.shiro.core.service;

import com.xub.shiro.core.entity.TbSysPermission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
public interface ITbSysPermissionService extends IService<TbSysPermission> {

    List<TbSysPermission> selectSysPermissionByRoleId(String id);
}
