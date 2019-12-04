package com.xub.shiro.vo;



import com.xub.shiro.enums.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@Data
@EqualsAndHashCode
public class ResultVO implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer code;

    private String msg;

    private Object data;

    private ResultVO() {
    }

    public ResultVO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVO success() {
        return new ResultVO(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMsg());
    }

    public static ResultVO success(String msg) {
        return new ResultVO(ResultCodeEnum.SUCCESS.getCode(), msg);
    }

    public static ResultVO success(Integer code, String msg) {
        return new ResultVO(code, msg);
    }

    public static ResultVO success(String msg, Object data) {
        return new ResultVO(ResultCodeEnum.SUCCESS.getCode(), msg, data);
    }

    public static ResultVO success(String msg, String dataDesc, Object data) {
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put(dataDesc, data);
        return new ResultVO(ResultCodeEnum.SUCCESS.getCode(), msg, resultMap);
    }

    public static ResultVO success(Integer code, String msg, Object data) {
        return new ResultVO(code, msg, data);
    }


    public static ResultVO success(Integer code, String msg, String dataDesc, Object data) {
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put(dataDesc, data);
        return new ResultVO(code, msg, resultMap);
    }



    public static ResultVO fail(String msg) {
        return new ResultVO(ResultCodeEnum.FAIL.getCode(), msg);
    }

    public static ResultVO fail(Integer code, String msg) {
        return new ResultVO(code, msg);
    }

    public static ResultVO fail(String msg, Object data) {
        return new ResultVO(ResultCodeEnum.FAIL.getCode(), msg, data);
    }

    public static ResultVO fail(String msg, String dataDesc, Object data) {
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put(dataDesc, data);
        return new ResultVO(ResultCodeEnum.FAIL.getCode(), msg, resultMap);
    }

    public static ResultVO fail(Integer code, String msg, Object data) {
        return new ResultVO(code, msg, data);
    }


    public static ResultVO fail(Integer code, String msg, String dataDesc, Object data) {
        Map<String, Object> resultMap = new HashMap<>(1);
        resultMap.put(dataDesc, data);
        return new ResultVO(code, msg, resultMap);
    }
}
