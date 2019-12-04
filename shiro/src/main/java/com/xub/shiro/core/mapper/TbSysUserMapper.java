package com.xub.shiro.core.mapper;

import com.xub.shiro.core.entity.TbSysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@Mapper
@Repository
public interface TbSysUserMapper extends BaseMapper<TbSysUser> {

    TbSysUser selectUserByName(String userName);
}
