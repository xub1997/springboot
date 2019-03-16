package com.xub.wechat.pojo.bo;

/**
 * @ClassName ReturnResult
 * @Description TODO
 * @Author lqx
 * @Date 2019/3/10.17:02
 **/
public class ReturnResult {
    private int code;
    private AddressData data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public AddressData getData() {
        return data;
    }

    public void setData(AddressData data) {
        this.data = data;
    }
}
