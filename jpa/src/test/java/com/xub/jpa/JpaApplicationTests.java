package com.xub.jpa;

import com.xub.jpa.dao.UserRepository;
import com.xub.jpa.entity.TbUserPO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@SpringBootTest
class JpaApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    void save() {
        TbUserPO userPO = new TbUserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setUserName("测试1");
        userRepository.save(userPO);
    }

    @Test
    void findAll() {
        List<TbUserPO> all = userRepository.findAll();
        System.out.println(String.format("findAll数量： %d", all.size()));
    }

    @Test
    void findAllByExample() {
        TbUserPO userPO = new TbUserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setUserName("测试1");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example example = Example.of(userPO, matcher);
        List<TbUserPO> all = userRepository.findAll(example);
        //等价于 select * from tb_user where name like %xxx%
        System.out.println(String.format("findAllByExample数量： %d", all.size()));
    }

    @Test
    void countByExample() {
        TbUserPO userPO = new TbUserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setUserName("测试1");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("user_name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example example = Example.of(userPO, matcher);
        //等价于 select count(*) from tb_user where name like %xxx%
        long count = userRepository.count(example);
        System.out.println(String.format("countByExample数量： %d", count));
    }

    @Test
    void pageByExample() {
        TbUserPO userPO = new TbUserPO();
        userPO.setId(UUID.randomUUID().toString());
        userPO.setUserName("测试1");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("user_name", ExampleMatcher.GenericPropertyMatchers.contains());
        Example example = Example.of(userPO, matcher);
        Pageable pageable = PageRequest.of(0,10,Sort.Direction.DESC,"createTime");
        Page<TbUserPO> all = userRepository.findAll(example,pageable);
        System.out.println(String.format("pageByExample数量： %d", all.getTotalElements()));
    }

    @Test
    void getAllUser() {
        List<TbUserPO> all = userRepository.getAllUser();
        System.out.println(String.format("getAllUser 数量： %d", all.size()));
    }

    @Test
    void getAllUserNative() {
        List<TbUserPO> all = userRepository.getAllUserNative();
        System.out.println(String.format("getAllUserNative数量： %d", all.size()));
    }

    @Test
    void getByIdNative() {
        TbUserPO userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }

    @Test
    void getByNameAndPwd() {
        TbUserPO userPO = userRepository.getByUserNameEqualsAndPwdEquals("userName1","pwd");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }

    @Test
    void updateUser() {
        TbUserPO userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
        int num = userRepository.updateUser("测试pwd","1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("updateUser： %d", num));
        userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }

    @Test
    void updateUserNative() {
        TbUserPO userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
        int num = userRepository.updateUserNative("测试pwd","1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("updateUserNative： %d", num));
        userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }

    @Test
    void deleteByUserName() {
        TbUserPO userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
        int num = userRepository.deleteByUserName("userName0");
        System.out.println(String.format("getByIdNative： %d", num));
        userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }

    @Test
    void deleteByIdNative() {
        TbUserPO userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
        int num = userRepository.deleteByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %d", num));
        userPO = userRepository.getByIdNative("1ac62eb3-b242-47a2-bab1-204ea20e4ed0");
        System.out.println(String.format("getByIdNative： %s", userPO));
    }


}
