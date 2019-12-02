package com.xub.shiro.core.service.impl;

import com.xub.shiro.core.entity.TbSysPermission;
import com.xub.shiro.core.mapper.TbSysPermissionMapper;
import com.xub.shiro.core.service.ITbSysPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
