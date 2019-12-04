package com.xub.shiro.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description: redis配置
 * @author: 黎清许
 * @create: 2019-12-02 15:48
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

    private String host;

    private Integer port;

    private Integer timeout;

    private String password;
}
