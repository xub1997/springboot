package com.xub.sprinboot.study.sba.server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-25
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler
                = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl("/");

        // 启用HTTP-Basic支持。这是Spring Boot Admin Client注册所必需的
        http.authorizeRequests()
                // 授予对所有静态资产和登录页面的公共访问权限
                .antMatchers("/assets/**").permitAll()
                // 授予对所有静态资产和登录页面的公共访问权限
                .antMatchers("/login").permitAll()
                // 所有请求都需要验证登录
                .anyRequest().authenticated().and()
                // 登录表单
                .formLogin().loginPage("/login").successHandler(successHandler).and()
                // 登出表单
                .logout().logoutUrl("/logout").and()
                .httpBasic().and()
                //	Enables CSRF-Protection using Cookies
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .ignoringAntMatchers(
                        //	将服务注册的接口暴露出去
                        "/instances",
                        "/actuator/**"
                );
    }
}
