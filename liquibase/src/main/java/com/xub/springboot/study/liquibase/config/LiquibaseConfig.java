package com.xub.springboot.study.liquibase.config;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author liqingxu
 * @Description
 * @create 2022-04-07
 */
@Configuration
public class LiquibaseConfig {
    @Value("${dc.version:main}")
    private String contexts;
    @Value("${dc.liquibase.enable:true}")
    private Boolean enable;

    private static final String DATABASE_CHANGE_LOG_TABLE = "lqb_changelog_test";
    private static final String DATABASE_CHANGE_LOG_LOCK_TABLE = "lqb_lock_test";

    /**
     *  指定数据源   
     */
    @Resource
    private DataSource dataSource;

    /**
     * Liquibase bean声明
     */
    @Bean("liquibase")
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();
        // Liquibase文件路径
        liquibase.setChangeLog("classpath:sql/master.xml");
        liquibase.setDataSource(dataSource);
        if (StringUtils.isNotBlank(contexts)) {
            liquibase.setContexts(contexts);
        }
        liquibase.setShouldRun(enable);
        liquibase.setResourceLoader(new DefaultResourceLoader());
        // 覆盖Liquibase changelog表名
        liquibase.setDatabaseChangeLogTable(DATABASE_CHANGE_LOG_TABLE);
        liquibase.setDatabaseChangeLogLockTable(DATABASE_CHANGE_LOG_LOCK_TABLE);
        return liquibase;
    }
}
