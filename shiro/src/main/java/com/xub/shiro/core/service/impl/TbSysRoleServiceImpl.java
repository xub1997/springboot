package com.xub.shiro.core.service.impl;

import com.xub.shiro.core.entity.TbSysRole;
import com.xub.shiro.core.mapper.TbSysRoleMapper;
import com.xub.shiro.core.service.ITbSysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Service
public class TbSysRoleServiceImpl extends ServiceImpl<TbSysRoleMapper, TbSysRole> implements ITbSysRoleService {

    @Autowired
    private TbSysRoleMapper roleMapper;

    @Override
    public List<TbSysRole> selectSysRoleByUserId(String userId) {
        List<TbSysRole> sysRoleList = roleMapper.selectSysRoleByUserId(userId);
        return sysRoleList;
    }
}
