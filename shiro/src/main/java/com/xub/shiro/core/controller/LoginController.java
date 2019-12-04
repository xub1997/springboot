package com.xub.shiro.core.controller;

import com.xub.shiro.utils.ShiroUtil;
import com.xub.shiro.vo.ResultVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-12-04 16:49
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@RestController
public class LoginController {
    /**
     * 登录
     */
    @PostMapping("/login")
    public ResultVO login(@RequestParam("userName") String userName,
                          @RequestParam("pwd") String pwd,
                          @RequestParam(name = "rememberMe", defaultValue = "false") Boolean rememberMe) {
        //进行身份验证
        try {
            //验证身份和登陆
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd, rememberMe);
            //验证成功进行登录操作
            subject.login(token);
        } catch (IncorrectCredentialsException e) {
            return  ResultVO.fail(500,"用户不存在或者密码错误");
        } catch (LockedAccountException e) {
            return  ResultVO.fail(500,"登录失败，该用户已被冻结");
        } catch (AuthenticationException e) {
            return  ResultVO.fail(500,"该用户不存在");
        } catch (Exception e) {
            return  ResultVO.fail(500,"未知异常,请联系管理员");
        }
        return  ResultVO.success("登录成功","token",ShiroUtil.getSession().getId().toString());
    }
}
