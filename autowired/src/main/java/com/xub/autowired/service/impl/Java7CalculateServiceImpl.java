package com.xub.autowired.service.impl;

import com.xub.autowired.service.CalculateService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("Java7")
@Service
public class Java7CalculateServiceImpl implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("Java7");
        Integer sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }
}
