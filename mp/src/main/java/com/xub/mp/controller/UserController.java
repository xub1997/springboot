package com.xub.mp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xub.mp.entity.UserPO;
import com.xub.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 17:21
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 新增用户信息
     */
    @PostMapping("/save")
    public void saveInfo(){
        UserPO userPO = new UserPO();
        userPO.setName("张三");
        userPO.setAge(12);
        userPO.setEmail("xxx@baomidou.com");
        userService.save(userPO);
    }

    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @PostMapping("/saveBatch")
    public void saveInfoList(){
        //创建对象
        UserPO userPO1 = new UserPO();
        userPO1.setName("张三");
        userPO1.setAge(12);
        userPO1.setEmail("xxx@baomidou.com");
        UserPO userPO2 = new UserPO();
        userPO2.setName("张三");
        userPO2.setAge(12);
        userPO2.setEmail("xxx@baomidou.com");
        //批量保存
        userService.saveBatch(Arrays.asList(userPO1,userPO2));
    }

    /**
     * 根据ID获取用户信息
     */
    @GetMapping("/getById")
    public UserPO getById(String id){
        UserPO UserPO = userService.getById(id);
        return UserPO;
    }

    /**
     * 根据指定字段查询用户信息集合
     */
    @RequestMapping("/getByMap")
    public Collection<UserPO> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<UserPO> UserPOList = userService.listByMap(map);
        return UserPOList;
    }

    /**
     * 根据id更新用户信息
     */
    @PutMapping("/updateById")
    public void updateById(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserPO UserPO = new UserPO();
        UserPO.setId(1L);
        UserPO.setAge(19);
        userService.updateById(UserPO);
    }


    /**
     * 新增或者更新用户信息
     */
    @PostMapping("/saveOrUpdate")
    public void saveOrUpdate(){
        //传入的实体类UserPO中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserPO UserPO = new UserPO();
        UserPO.setId(1L);
        UserPO.setAge(20);
        userService.saveOrUpdate(UserPO);
    }

    /**
     * 根据ID删除用户信息
     */
    @DeleteMapping("/removeById")
    public void removeById(String userId){
        userService.removeById(userId);
    }

    /**
     * 根据ID批量删除用户信息
     */
    @DeleteMapping("/removeByIds")
    public void removeByIds(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("1");
        userIdlist.add("2");
        userService.removeByIds(userIdlist);
    }

    /**
     * 根据指定字段删除用户信息
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("age","12");
        userService.removeByMap(map);
    }

    /**
     * 查询全部信息
     */
    @GetMapping("/getList")
    public List<UserPO> getList(){
        List<UserPO> UserPOList = userService.list();
        return UserPOList;
    }



}
