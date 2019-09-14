package com.xxxx.common.bean;

import com.xxxx.common.constant.ResponseCode;

/**
 * @author zenghuanghui（20260606）
 * @since 2019/9/14 09:12
 */
public class ResponseInfo<T> {

    private String code = ResponseCode.CODE_SUCCESS;

    private T data;

    public ResponseInfo() {
    }

    public ResponseInfo(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseInfo(T data) {
        this.data = data;
    }

    public ResponseInfo(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
