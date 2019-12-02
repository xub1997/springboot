package com.xub.security.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.security.core.entity.TbSysUser;


/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
public interface ITbSysUserService extends IService<TbSysUser> {

    TbSysUser selectUserByName(String username);
}
