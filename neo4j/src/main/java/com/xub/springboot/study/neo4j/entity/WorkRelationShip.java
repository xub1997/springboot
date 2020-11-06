package com.xub.springboot.study.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.*;

/**
 * @author liqingxu
 * @desc WorkRelationShip
 * @date 2020/11/6 9:20
 */
@Data
@RelationshipEntity(type = "work_for")
public class WorkRelationShip {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Employee employee;

    @EndNode
    private Company company;
}
