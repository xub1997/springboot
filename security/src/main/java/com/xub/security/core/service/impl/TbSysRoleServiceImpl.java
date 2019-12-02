package com.xub.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xub.security.core.entity.TbSysRole;
import com.xub.security.core.mapper.TbSysRoleMapper;
import com.xub.security.core.service.ITbSysRoleService;
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
