package com.xub.springboot.study.type_inference.pojo;

import java.util.StringJoiner;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
public class User {

    private Long id;

    private String userName;

    private String pwd;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("userName='" + userName + "'")
                .add("pwd='" + pwd + "'")
                .toString();
    }
}
