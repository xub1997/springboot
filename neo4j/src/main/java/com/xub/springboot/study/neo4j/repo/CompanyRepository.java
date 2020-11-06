package com.xub.springboot.study.neo4j.repo;

import com.xub.springboot.study.neo4j.entity.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liqingxu
 * @desc CompanyRepository
 * @date 2020/11/6 9:15
 */
@Repository
public interface CompanyRepository extends Neo4jRepository<Company, Long> {
}
