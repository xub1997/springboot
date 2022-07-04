package com.xub.springboot.study.type_inference.service.impl;

import com.xub.springboot.study.type_inference.mapper.Mapper;
import com.xub.springboot.study.type_inference.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-04
 */
public class IServiceImpl<E extends Mapper<T>, T> implements IService<T> {

    @Autowired
    private E mapper;

    public E getMapper() {
        return this.mapper;
    }

    @Override
    public void service(T t) {
        mapper.mapper(t);
    }
}
