package com.xub.shiro.core.service.impl;

import com.xub.shiro.core.entity.TbSysUser;
import com.xub.shiro.core.mapper.TbSysUserMapper;
import com.xub.shiro.core.service.ITbSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
