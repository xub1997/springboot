package com.xub.es.service.impl;

import com.xub.es.dao.UserESRepository;
import com.xub.es.entity.UserESPO;
import com.xub.es.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:58
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Service
public class UserServiceImpl implements UserService {

    private UserESRepository userESRepository;

    @Override
    public void save(UserESPO userESPO) {
        userESRepository.save(userESPO);
    }

    @Override
    public UserESPO getById(String id) {
        return userESRepository.findById(id).orElseThrow(()->{throw new RuntimeException("找不到对应数据");});
    }

    @Override
    public void updateById(UserESPO userESPO) {

    }

    @Override
    public void deleteById(String id) {
        userESRepository.deleteById(id);
    }

    @Override
    public List<UserESPO> getList() {
        return null;
    }
}
