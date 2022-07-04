package com.xub.springboot.study.type_inference.service;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
public interface IService<T> {
    void service(T t);
}
