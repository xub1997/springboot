package com.xub.security.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.security.core.entity.TbSysRole;


import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
public interface ITbSysRoleService extends IService<TbSysRole> {

    List<TbSysRole> selectSysRoleByUserId(String userId);
}
