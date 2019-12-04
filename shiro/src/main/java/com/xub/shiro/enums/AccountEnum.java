package com.xub.shiro.enums;

import lombok.Getter;
import lombok.NonNull;

/**
 * @description: 账号状态枚举
 * @author: 黎清许
 * @create: 2019-12-04 14:35
 * <p>
 * CopyRight &copy; All rights reserved.
 **/
@Getter
public enum AccountEnum {

    /**
     * 正常使用
     */
    NORMAL(1, "正常使用"),
    /**
     * 禁用
     */
    FORBIDDEN(2, "禁用"),
    /**
     * 停止使用
     */
    STOP_USE(3, "停止使用");
    private Integer code;
    private String desc;

    AccountEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static AccountEnum getByCode(Integer code) {
        AccountEnum[] values = AccountEnum.values();
        for (AccountEnum value : values) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return STOP_USE;
    }

    public static void main(String[] args) {
        System.out.println(getByCode(1));
        System.out.println(getByCode(null));
        System.out.println(getByCode(4));
        System.out.println(NORMAL.code.equals(1));
    }
}
