package com.xub.shiro.core.controller;


import com.xub.shiro.utils.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author xub
 * @since 2019-12-04
 */
@RestController
@RequestMapping("/user")
public class TbSysUserController {

    /**
     * 登录
     */
    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam("userName") String userName,
                                     @RequestParam("pwd") String pwd,
                                     @RequestParam(name = "rememberMe", defaultValue = "false") Boolean rememberMe) {
        Map<String, Object> map = new HashMap<>();
        //进行身份验证
        try {
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd, rememberMe);
            //验证成功进行登录操作
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            map.put("code", 500);
            map.put("msg", "用户不存在或者密码错误");
            return map;
        } catch (LockedAccountException e) {
            map.put("code", 500);
            map.put("msg", "登录失败，该用户已被冻结");
            return map;
        } catch (AuthenticationException e) {
            map.put("code", 500);
            map.put("msg", "该用户不存在");
            return map;
        } catch (Exception e) {
            map.put("code", 500);
            map.put("msg", "未知异常");
            return map;
        }
        map.put("code", 0);
        map.put("msg", "登录成功");
        map.put("token", ShiroUtil.getSession().getId().toString());
        return map;
    }
}
