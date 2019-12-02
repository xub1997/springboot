package com.xub.security.core.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.xub.security.core.entity.TbSysPermission;
import com.xub.security.core.mapper.TbSysPermissionMapper;
import com.xub.security.core.service.ITbSysPermissionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xub
 * @since 2019-12-02
 */
@Service
public class TbSysPermissionServiceImpl extends ServiceImpl<TbSysPermissionMapper, TbSysPermission> implements ITbSysPermissionService {

    @Override
    public List<TbSysPermission> selectSysPermissionByRoleId(String id) {
        return null;
    }
}
