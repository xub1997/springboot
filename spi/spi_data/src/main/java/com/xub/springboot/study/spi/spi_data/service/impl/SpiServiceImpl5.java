package com.xub.springboot.study.spi.spi_data.service.impl;

import com.google.auto.service.AutoService;
import com.xub.springboot.study.spi.spi_data.service.SpiService;

/**
 * @author liqingxu
 * @Description
 * @create 2022-07-08
 */
@AutoService(SpiService.class)
public class SpiServiceImpl5 implements SpiService {
    @Override
    public void hello() {
        System.out.println("SpiServiceImpl5");
    }
}
