package com.xub.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-27 09:29
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Data
@Document(indexName = "user",type = "_doc")
public class ArticlePO {

    @Id
    private Integer id;              //主键ID

    @Field(type = FieldType.Keyword)
    private Integer smallType;       //小分类ID

    @Field(type = FieldType.Keyword)
    private Integer bigType;         //大分类ID

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;   //标题

    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String content; //内容
}
