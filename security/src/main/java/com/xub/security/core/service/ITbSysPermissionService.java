package com.xub.security.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.security.core.entity.TbSysPermission;


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
