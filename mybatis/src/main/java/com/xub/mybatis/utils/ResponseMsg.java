package com.xub.mybatis.utils;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class ResponseMsg<T> implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;

    private int status;
    private String msg;

    private T data;

    private ResponseMsg(int status){
        this.status = status;
    }
    private ResponseMsg(int status, T data){
        this.status = status;
        this.data = data;
    }

    private ResponseMsg(int status, String msg, T data){
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    private ResponseMsg(int status, String msg){
        this.status = status;
        this.msg = msg;
    }

    @JsonIgnore
    //使之不在json序列化结果当中
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public int getStatus(){
        return status;
    }
    public T getData(){
        return data;
    }
    public String getMsg(){
        return msg;
    }


    public static <T> ResponseMsg<T> Success(){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ResponseMsg<T> Success(String msg){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ResponseMsg<T> Success(T data){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ResponseMsg<T> Success(String msg, T data){
        return new ResponseMsg<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }


    public static <T> ResponseMsg<T> Error(){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDescrition());
    }


    public static <T> ResponseMsg<T> Error(String errorMessage){
        return new ResponseMsg<T>(ResponseCode.ERROR.getCode(),errorMessage);
    }

    public static <T> ResponseMsg<T> Error(int errorCode, String errorMessage){
        return new ResponseMsg<T>(errorCode,errorMessage);
    }


}
