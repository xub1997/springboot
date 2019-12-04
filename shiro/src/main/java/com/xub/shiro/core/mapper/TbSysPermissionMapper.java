package com.xub.shiro.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xub.shiro.core.entity.TbSysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Mapper
@Repository
public interface TbSysPermissionMapper extends BaseMapper<TbSysPermission> {

    List<TbSysPermission> selectSysPermissionByUserId(String userId);
}
