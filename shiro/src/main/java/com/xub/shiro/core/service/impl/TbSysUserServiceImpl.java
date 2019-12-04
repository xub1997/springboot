package com.xub.shiro.core.service.impl;

import com.xub.shiro.core.entity.TbSysUser;
import com.xub.shiro.core.mapper.TbSysUserMapper;
import com.xub.shiro.core.service.ITbSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Service
public class TbSysUserServiceImpl extends ServiceImpl<TbSysUserMapper, TbSysUser> implements ITbSysUserService {

    @Autowired
    private TbSysUserMapper userMapper;

    @Override
    public TbSysUser selectUserByName(String userName) {
        TbSysUser userInfo = userMapper.selectUserByName(userName);
        return userInfo;
    }
}
