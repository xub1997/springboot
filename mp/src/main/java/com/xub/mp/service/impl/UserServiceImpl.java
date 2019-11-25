package com.xub.mp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xub.mp.entity.UserPO;
import com.xub.mp.mapper.UserMapper;
import com.xub.mp.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 16:50
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserPO> implements IUserService {

    @Override
    public IPage<UserPO> selectPageVo(IPage<UserPO> page, Integer age) {
        return this.baseMapper.selectPageVo(page, age);
    }
}
