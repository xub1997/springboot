package com.xub.springboot.study.mapstruct.enums;

import com.xub.springboot.study.mapstruct.transfer.IReadableEnum;

/**
 * @author liqingxu
 * @Description
 * @create 2022-06-30
 */
public enum SexEnum implements IReadableEnum {
    MAN(1,"男"),
    WOMEN(2,"女");

    private int code;
    private String desc;

    SexEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public String getReadableString() {
        return this.desc;
    }
}
