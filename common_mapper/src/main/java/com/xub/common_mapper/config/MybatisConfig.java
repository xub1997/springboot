package com.xub.common_mapper.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import java.sql.SQLException;
import java.util.Properties;

@Configuration
public class MybatisConfig {

    @Autowired
    DruidBean druidProperties;

    @Autowired
    PageHelperBean pageHelperProperties;

    /**
     * druid的数据源
     */
    private DruidDataSource dataSourceStrom() {
        DruidDataSource dataSource = new DruidDataSource();
        druidProperties.config(dataSource);
        return dataSource;
    }

    /**
     * 单数据源连接池配置
     */
    @Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        return dataSourceStrom();
    }

    //配置mybatis的分页插件pageHelper
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("offsetAsPageNum",pageHelperProperties.getOffsetAsPageNum());
        properties.setProperty("rowBoundsWithCount",pageHelperProperties.getRowBoundsWithCount());
        properties.setProperty("dialect",pageHelperProperties.getDialect());    //配置mysql数据库的方言
        properties.setProperty("pageSizeZero", pageHelperProperties.getPageSizeZero());//分页尺寸为0时查询所有纪录不再执行分页
        properties.setProperty("reasonable", pageHelperProperties.getReasonable());  //页码<=0 查询第一页，页码>=总页数查询最后一页
        properties.setProperty("supportMethodsArguments", pageHelperProperties.getSupportMethodsArguments());//支持通过 Mapper 接口参数来传递分页参数
        pageHelper.setProperties(properties);
        return pageHelper;
    }

    /*
     * 配置事务管理
     * */
    @Bean
    @Primary
    public DataSourceTransactionManager masterTransactionManager() throws SQLException { return new DataSourceTransactionManager(dataSource()); }


}
