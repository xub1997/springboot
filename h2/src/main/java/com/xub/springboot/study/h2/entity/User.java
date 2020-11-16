package com.xub.springboot.study.h2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "pwd")
    private String pwd;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @Column(name = "create_time")
    private Date createTime;
}
