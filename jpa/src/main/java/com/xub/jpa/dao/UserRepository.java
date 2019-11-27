package com.xub.jpa.dao;

import com.xub.jpa.entity.TbUserPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @description:
 * @author: 黎清许
 * @create: 2019-11-27 09:41
 * <p>
 * CopyRight &copy; All rights reserved.
 *
 *
 **/
@Repository
public interface UserRepository extends JpaRepository<TbUserPO, String> {

    /**
     * 使用SpEL表达式
     * 表名需变成实体类名称（标注了@Entity的类）
     * @return
     */
    @Query("select u from  TbUserPO u")
    List<TbUserPO> getAllUser();

    /**
     * 使用原生SQL（需添加nativeQuery=true）
     * @return
     */
    @Query(value = "select u.* from  tb_user u", nativeQuery = true)
    List<TbUserPO> getAllUserNative();

    /**
     * 使用原生SQL（需添加nativeQuery=true）
     * @param id
     * @return
     */
    @Query(value = "select u.* from  tb_user u where u.id = ?1", nativeQuery = true)
    TbUserPO getByIdNative(String id);

    /**
     * 使用属性表达式（Property Expressions）
     * @param userName
     * @param pwd
     * @return
     */
    TbUserPO getByUserNameEqualsAndPwdEquals(String userName, String pwd);

    /**
     * update、delete操作涉及到事务机制，需要进行设置
     * 调用这个方法的service类上加上注解@Transactional（import org.springframework.transaction.annotation.Transactional;）
     * @param pwd
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update TbUserPO u set u.pwd = ?1 where u.id = ?2")
    int updateUser(String pwd, String id);

    /**
     * update、delete操作涉及到事务机制，需要进行设置
     * 调用这个方法的service类上加上注解@Transactional（import org.springframework.transaction.annotation.Transactional;）
     * @param firstName
     * @param idCard
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "update tb_user set pwd = ?1 where id = ?2", nativeQuery = true)
    int updateUserNative(String firstName, String idCard);

    /**
     * update、delete操作涉及到事务机制，需要进行设置
     * 调用这个方法的service类上加上注解@Transactional（import org.springframework.transaction.annotation.Transactional;）
     * @param userName
     * @return
     */
    @Transactional
    @Modifying
    @Query("delete from TbUserPO u where u.userName = ?1")
    int deleteByUserName(String userName);

    /**
     * update、delete操作涉及到事务机制，需要进行设置
     * 调用这个方法的service类上加上注解@Transactional（import org.springframework.transaction.annotation.Transactional;）
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query(value = "delete from tb_user where id = ?1", nativeQuery = true)
    int deleteByIdNative(String id);

}
