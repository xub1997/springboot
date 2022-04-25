package com.xub.sprinboot.study.sba.client.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-25
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Security默认是拦截所有的请求，但是我们这里指需要让它拦截actuator的接口即可，业务相关的接口由业务权限系统去控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers("/actuator/**").authenticated().anyRequest().permitAll();
    }
}
