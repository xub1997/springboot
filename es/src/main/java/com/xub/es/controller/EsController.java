package com.xub.es.controller;

import com.xub.es.entity.UserESPO;
import com.xub.es.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-12-02 09:22
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
public class EsController {

    @Autowired
    private UserService userService;

    public void save(UserESPO userESPO) {
        userService.save(userESPO);
    }

    public UserESPO getById(String id) {
        return userService.getById(id);
    }

    public void updateById(UserESPO userESPO) {

    }


    public void deleteById(String id) {
        userService.deleteById(id);
    }

    public List<UserESPO> getList() {
        return null;
    }
}
