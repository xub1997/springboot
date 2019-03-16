package com.xub.wechat.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResponseData
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/10.16:09
 **/
public class ResponseData implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private String msg;
    private Map<String, Object> data=new HashMap<>();;

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

    public Map<String, Object> getData() {
        return data;
    }

    private ResponseData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResponseData putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    public static ResponseData ok(String msg) {
        return new ResponseData(200, msg);
    }

    public static ResponseData error(String msg) {
        return new ResponseData(100, msg);
    }

    public static ResponseData exception(int code, String msg) {
        return new ResponseData(code, msg);
    }


}
