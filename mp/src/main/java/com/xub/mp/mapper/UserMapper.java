package com.xub.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xub.mp.entity.UserPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 16:23
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Repository
public interface UserMapper extends BaseMapper<UserPO> {
    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * 注意!!: 如果入参是有多个,需要加注解指定参数名才能在xml中取值
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @param age 年龄
     * @return 分页对象
     */
    IPage<UserPO> selectPageVo(IPage<UserPO> page, @Param("age") Integer age);
}
