package com.xub.springboot.study.neo4j;

import com.xub.springboot.study.neo4j.entity.Company;
import com.xub.springboot.study.neo4j.entity.Employee;
import com.xub.springboot.study.neo4j.entity.WorkRelationShip;
import com.xub.springboot.study.neo4j.repo.CompanyRepository;
import com.xub.springboot.study.neo4j.repo.EmployeeRepository;
import com.xub.springboot.study.neo4j.repo.WorkRelationShipRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class Neo4jApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private WorkRelationShipRepository workRelationShipRepository;

    @Test
    void contextLoads() {
        Employee employee1 = new Employee();
        employee1.setName("张三");
        employeeRepository.save(employee1);

        Employee employee2 = new Employee();
        employee2.setName("李四");
        employeeRepository.save(employee2);

        Employee employee3 = new Employee();
        employee3.setName("王五");
        employeeRepository.save(employee3);

        Employee employee4 = new Employee();
        employee4.setName("赵六");
        employeeRepository.save(employee4);

        Company company1 = new Company();
        company1.setName("腾讯");
        companyRepository.save(company1);

        Company company2 = new Company();
        company2.setName("阿里");
        companyRepository.save(company2);

        WorkRelationShip workRelationShip1 = new WorkRelationShip();
        workRelationShip1.setEmployee(employee1);
        workRelationShip1.setCompany(company1);
        workRelationShipRepository.save(workRelationShip1);

        WorkRelationShip workRelationShip2 = new WorkRelationShip();
        workRelationShip2.setEmployee(employee2);
        workRelationShip2.setCompany(company1);
        workRelationShipRepository.save(workRelationShip2);


        WorkRelationShip workRelationShip3 = new WorkRelationShip();
        workRelationShip3.setEmployee(employee3);
        workRelationShip3.setCompany(company2);
        workRelationShipRepository.save(workRelationShip3);

        WorkRelationShip workRelationShip4 = new WorkRelationShip();
        workRelationShip4.setEmployee(employee4);
        workRelationShip4.setCompany(company2);
        workRelationShipRepository.save(workRelationShip4);
    }

    @Test
    void testUpdate() {
        Optional<Employee> byId = employeeRepository.findById(14L);
        if(byId.isPresent()){
            Employee employee = byId.get();
            employee.setName("11111");
            employeeRepository.save(employee);
        }
    }

    @Test
    void multiLabels() {
        Company company1 = new Company();
        company1.setName("腾讯");
        company1.addLabel("1111");
        company1.addLabel("2222");
        companyRepository.save(company1);
    }


}
