package com.xub.springboot.study.type_inference.mapper;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
public interface Mapper<T> {
    void mapper(T t);
}
