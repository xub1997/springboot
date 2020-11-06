package com.xub.springboot.study.neo4j.repo;

import com.xub.springboot.study.neo4j.entity.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liqingxu
 * @desc EmployeeRepository
 * @date 2020/11/6 9:15
 */
@Repository
public interface EmployeeRepository extends Neo4jRepository<Employee, Long> {
}
