package com.example.enumeration;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 14:02
 * @version:1.0
 */
public enum ResponseStatus {
    SUCCESS(200, "success", "成功"),
    PARAM_ERROR(300, "paramerror", "参数错误"),
    UK_ERROR(301, "UK_error", "数据重复"),
    LOGIN_INVALID(302, "login_invalid", "登录失效，请重新登录"),
    FAIL(500, "fail", "失败"),
    GATEWAY_ERROR(502, "gateWayError", "网关错误");

    int code;
    String msg;
    String fullMsg;

    private ResponseStatus(int code, String msg, String fullMsg) {
        this.code = code;
        this.msg = msg;
        this.fullMsg = fullMsg;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getFullMsg() {
        return this.fullMsg;
    }
}
