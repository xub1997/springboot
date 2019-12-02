package com.xub.es.service;

import com.xub.es.entity.UserESPO;

import java.util.List;


/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-28 14:57
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
public interface UserService {

    void save(UserESPO userESPO);

    UserESPO getById(String id);

    void updateById(UserESPO userESPO);

    void deleteById(String id);

    List<UserESPO> getList();
}
