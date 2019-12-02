package com.xub.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xub.security.core.entity.TbSysUser;
import com.xub.security.core.mapper.TbSysUserMapper;
import com.xub.security.core.service.ITbSysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Service
public class TbSysUserServiceImpl extends ServiceImpl<TbSysUserMapper, TbSysUser> implements ITbSysUserService {

    @Override
    public TbSysUser selectUserByName(String username) {
        return null;
    }
}
