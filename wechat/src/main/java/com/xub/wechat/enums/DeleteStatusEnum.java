package com.xub.wechat.enums;

public enum DeleteStatusEnum {
    DELETE(1,"已删除"),
    NOT_DELETE(0,"未删除");
    private int code;
    private String msg;

    DeleteStatusEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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
}
