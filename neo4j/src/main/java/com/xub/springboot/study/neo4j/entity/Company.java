package com.xub.springboot.study.neo4j.entity;

import lombok.Data;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;
import java.util.Set;

/**
 * @author liqingxu
 * @desc Parent
 * @date 2020/11/6 9:12
 */
@Data
@NodeEntity
public class Company {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @Labels
    private Set<String> labels = new HashSet<>();

    public Set<String> getLabels() {
        return labels;
    }

    public void addLabel(String name) {
        this.labels.add(name);
    }
}