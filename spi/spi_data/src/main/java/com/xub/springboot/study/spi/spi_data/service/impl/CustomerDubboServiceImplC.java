package com.xub.springboot.study.spi.spi_data.service.impl;

import com.xub.springboot.study.spi.spi_data.service.CustomerDubboService;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-08
 */
public class CustomerDubboServiceImplC implements CustomerDubboService {
    @Override
    public void hello(String name) {
        System.out.println("CustomerDubboServiceImplB, hello" + name);
    }
}
