package com.xub.shiro.enums;

import org.springframework.util.Assert;

/**
 * 返回结果：返回码及描述
 */
public enum ResultCodeEnum {


    /**
     * 操作失败
     */
    FAIL(-1, "操作失败"),
    /**
     * 操作成功
     */
    SUCCESS(0, "操作成功"),
    /**
     * 未知操作
     */
    UNKNOWN_OPERATION(100000,"未知操作");

    private final Integer code;
    private final String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code获取枚举
     * @param code
     * @return
     */
    public static ResultCodeEnum getByCode(Integer code){
        Assert.isNull(code,"code不能为空");
        ResultCodeEnum[] values = ResultCodeEnum.values();
        for (ResultCodeEnum value : values) {
            if(value.getCode().equals(code)){
                return value;
            }
        }
        return UNKNOWN_OPERATION;
    }

}
