package com.xub.springboot.study.customized_starter_demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//可以将application.properties中前缀为spring.datasource的配置项，自动注入到当前bean中
@ConfigurationProperties(prefix = "pagehelper")
public class PageHelperBean {
    private String offsetAsPageNum="true";// 设置为true时，会将RowBounds第一个参数offset当成pageNum页码使用
    private String rowBoundsWithCount="true";//设置为true时，使用RowBounds分页会进行count查询
    private String dialect="mysql";    //配置mysql数据库的方言
    private String pageSizeZero= "true";//分页尺寸为0时查询所有纪录不再执行分页
    private String reasonable= "true";  //页码<=0 查询第一页，页码>=总页数查询最后一页
    private String supportMethodsArguments= "true";//支持通过 Mapper 接口参数来传递分页参数

    public String getOffsetAsPageNum() {
        return offsetAsPageNum;
    }

    public void setOffsetAsPageNum(String offsetAsPageNum) {
        this.offsetAsPageNum = offsetAsPageNum;
    }

    public String getRowBoundsWithCount() {
        return rowBoundsWithCount;
    }

    public void setRowBoundsWithCount(String rowBoundsWithCount) {
        this.rowBoundsWithCount = rowBoundsWithCount;
    }

    public String getDialect() {
        return dialect;
    }

    public void setDialect(String dialect) {
        this.dialect = dialect;
    }

    public String getPageSizeZero() {
        return pageSizeZero;
    }

    public void setPageSizeZero(String pageSizeZero) {
        this.pageSizeZero = pageSizeZero;
    }

    public String getReasonable() {
        return reasonable;
    }

    public void setReasonable(String reasonable) {
        this.reasonable = reasonable;
    }

    public String getSupportMethodsArguments() {
        return supportMethodsArguments;
    }

    public void setSupportMethodsArguments(String supportMethodsArguments) {
        this.supportMethodsArguments = supportMethodsArguments;
    }
}
