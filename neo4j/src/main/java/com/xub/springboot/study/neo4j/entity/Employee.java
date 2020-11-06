package com.xub.springboot.study.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author liqingxu
 * @desc User
 * @date 2020/11/6 9:11
 */
@Data
@NodeEntity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

}
