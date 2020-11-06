package com.xub.springboot.study.neo4j.repo;

import com.xub.springboot.study.neo4j.entity.WorkRelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liqingxu
 * @desc WorkRelationShipRepository
 * @date 2020/11/6 9:23
 */
@Repository
public interface WorkRelationShipRepository extends Neo4jRepository<WorkRelationShip,Long> {
}
