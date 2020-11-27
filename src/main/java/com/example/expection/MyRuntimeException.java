package com.example.expection;

import com.example.enumeration.ErrorTypeEnum;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 13:55
 * @version:1.0
 */
public class MyRuntimeException extends RuntimeException {


    private Integer code;

    public MyRuntimeException(ErrorTypeEnum errorTypeEnum){
        super(errorTypeEnum.getMessage());
        this.code = errorTypeEnum.getCode();
    }

    public MyRuntimeException(Integer code) {
        this.code = code;
    }

    public MyRuntimeException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public MyRuntimeException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public MyRuntimeException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
