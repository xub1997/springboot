package com.xub.shiro.core.service;

import com.xub.shiro.core.entity.TbSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
public interface ITbSysUserService extends IService<TbSysUser> {

    TbSysUser selectUserByName(String userName);
}
