package com.xub.shiro.core.service;

import com.xub.shiro.core.entity.TbSysRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
public interface ITbSysRoleService extends IService<TbSysRole> {

    List<TbSysRole> selectSysRoleByUserId(String userId);
}
