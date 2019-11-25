package com.xub.mp.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xub.mp.entity.UserPO;
import com.xub.mp.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-25 17:41
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
@RequestMapping("/userPlus")
public class UserPlusController {

    @Autowired
    private IUserService userService;

    /**
     * MP扩展演示
     */
    @RequestMapping("/getInfoListPlus")
    public Map<String,Object> getInfoListPage(){
        //初始化返回类
        Map<String,Object> result = new HashMap<>();
        //查询年龄等于18岁的学生
        //等价SQL: SELECT id,name,age,email FROM user WHERE age = 18
        QueryWrapper<UserPO> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.lambda().eq(UserPO::getAge,18);
        List<UserPO> userPOList1 = userService.list(queryWrapper1);
        result.put("userPOList1",userPOList1);
        //查询年龄大于5岁的学生且小于等于18岁的学生
        //等价SQL: SELECT id,name,age,email FROM user WHERE age > 5 AND age <= 18
        QueryWrapper<UserPO> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.lambda().gt(UserPO::getAge,5);
        queryWrapper2.lambda().le(UserPO::getAge,18);
        List<UserPO> userPOList2 = userService.list(queryWrapper2);
        result.put("userPOList2",userPOList2);
        //模糊查询姓名带有"张"的数据,并按照年龄降序
        //等价SQL: SELECT id,name,age,email FROM user WHERE name LIKE '%画%' ORDER BY age DESC
        QueryWrapper<UserPO> queryWrapper3 = new QueryWrapper<>();
        queryWrapper3.lambda().like(UserPO::getName,"张");
        queryWrapper3.lambda().orderByDesc(UserPO::getAge);
        List<UserPO> userPOList3 = userService.list(queryWrapper3);
        result.put("userPOList3",userPOList3);
        //模糊查询名字带有"小"或者年龄大于18的用户
        //等价SQL: SELECT id,name,age,email FROM user WHERE name LIKE '%小%' OR age > 18
        QueryWrapper<UserPO> queryWrapper4 = new QueryWrapper<>();
        queryWrapper4.lambda().like(UserPO::getName,"小");
        queryWrapper4.lambda().or().gt(UserPO::getAge,18);
        List<UserPO> userPOList4 = userService.list(queryWrapper4);
        result.put("userPOList4",userPOList4);
        //查询email不为null的学生,并且分页
        //等价SQL: SELECT id,name,age,email FROM user WHERE email IS NOT NULL LIMIT 0,5
        IPage<UserPO> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        QueryWrapper<UserPO> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.lambda().isNotNull(UserPO::getEmail);
        page = userService.page(page,queryWrapper5);
        result.put("userPage",page);
        return result;
    }


    /**
     * MP自定义SQL
     */
    /**
     * 分页查询全部数据
     */
    @GetMapping("/getInfoListPage")
    public IPage<UserPO> getInfoListPage(@RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize){
        //需要在Config配置类中配置分页插件
        IPage<UserPO> page = new Page<>();
        page.setCurrent(pageNum); //当前页
        page.setSize(pageSize);    //每页条数
        page = userService.page(page);
        return page;
    }
}
