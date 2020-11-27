package com.example.common;

import com.example.enumeration.ResponseStatus;

import java.io.Serializable;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 14:01
 * @version:1.0
 */
public class MyResponse<T> implements Serializable {
    private Boolean success;
    private T data;
    private Integer code = 200;
    private String msg = "操作成功";

    public MyResponse() {
    }

    public static MyResponse fail(String msg) {
        MyResponse response = new MyResponse();
        response.setSuccess(Boolean.FALSE);
        response.setCode(ResponseStatus.FAIL.getCode());
        response.setMsg(msg);
        return response;
    }

    public static MyResponse fail(Integer code, String msg) {
        MyResponse response = new MyResponse();
        response.setSuccess(Boolean.FALSE);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static MyResponse fail(MyResponse response, Integer code, String msg) {
        response.setSuccess(Boolean.FALSE);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }

    public static <T> MyResponse<T> succ(T data, String msg) {
        MyResponse response = new MyResponse();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseStatus.SUCCESS.getCode());
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public static <T> MyResponse<T> succ(T data) {
        MyResponse response = new MyResponse();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseStatus.SUCCESS.getCode());
        response.setData(data);
        return response;
    }


    public static <T> MyResponse<T> succ() {
        MyResponse response = new MyResponse();
        response.setSuccess(Boolean.TRUE);
        response.setCode(ResponseStatus.SUCCESS.getCode());
        response.setData("");
        return response;
    }


    @Override
    public String toString() {
        if (null != this.success && this.success) {
            return null == this.data ? null : this.data.toString();
        } else {
            return "{success=" + this.success + ", code=" + this.code + ", msg='" + this.msg + '\'' + '}';
        }
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(final Boolean success) {
        this.success = success;
    }

    public T getData() {
        return this.data;
    }

    public void setData(final T data) {
        this.data = data;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(final Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }
}
