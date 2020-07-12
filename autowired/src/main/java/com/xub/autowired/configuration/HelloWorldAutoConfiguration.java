package com.xub.autowired.configuration;

import com.xub.autowired.annotation.ConditionalOnSystemProperty;
import com.xub.autowired.annotation.EnabledHelloWorld;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnabledHelloWorld
@ConditionalOnSystemProperty(name = "user.name",value = "xub")
public class HelloWorldAutoConfiguration {
}
