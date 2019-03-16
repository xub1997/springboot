package com.xub.wechat.enums;

public enum RequestStatusEnum {

    Wait_Accept(1,"等待通过"),
    Pass(2,"通过"),
    Refuse(3,"拒绝通过"),
    Ignore(4,"忽略请求");


    public final int code;
    public final String msg;

    RequestStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
