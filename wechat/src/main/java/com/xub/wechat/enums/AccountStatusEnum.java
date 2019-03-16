package com.xub.wechat.enums;

public enum AccountStatusEnum {
    NORMAL(1,"正常"),
    LOCKED(2,"账号锁定"),
    REMOVE(3,"注销");

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    AccountStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
