package com.xub.shiro.core.mapper;

import com.xub.shiro.core.entity.TbSysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Mapper
@Repository
public interface TbSysRoleMapper extends BaseMapper<TbSysRole> {

    List<TbSysRole> selectSysRoleByUserId(String userId);
}
