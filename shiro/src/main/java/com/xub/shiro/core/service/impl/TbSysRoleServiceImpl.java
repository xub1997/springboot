package com.xub.shiro.core.service.impl;

import com.xub.shiro.core.entity.TbSysRole;
import com.xub.shiro.core.mapper.TbSysRoleMapper;
import com.xub.shiro.core.service.ITbSysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Service
public class TbSysRoleServiceImpl extends ServiceImpl<TbSysRoleMapper, TbSysRole> implements ITbSysRoleService {

    @Override
    public List<TbSysRole> selectSysRoleByUserId(String userId) {
        return null;
    }
}
