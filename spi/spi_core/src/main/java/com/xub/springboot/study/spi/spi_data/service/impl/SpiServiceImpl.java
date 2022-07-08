package com.xub.springboot.study.spi.spi_data.service.impl;

import com.xub.springboot.study.spi.spi_data.service.SpiService;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-07
 */
public class SpiServiceImpl implements SpiService {
    @Override
    public void hello() {
        System.out.println("SpiServiceImpl");
    }
}
