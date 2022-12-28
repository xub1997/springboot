package com.xub.springboot.study.elk.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liqingxu
 * @Description
 * @create 2022-12-27
 */
@Slf4j
@RestController
public class ELKController {

    @GetMapping("/debug")
    public String debug() {
        log.debug("debug");
        return "debug";
    }

    @GetMapping("/info")
    public String info() {
        log.info("info");
        return "info";
    }

    @GetMapping("/warn")
    public String warn() {
        log.warn("warn");
        return "warn";
    }

    @GetMapping("/errorLog")
    public String error() {
        try {
            throw new RuntimeException("test error");
        } catch (Exception e) {
            log.error("errorLog", e);
        }
        return "errorLog";
    }

}
