package com.example.expection.handle;

import com.example.common.MyResponse;
import com.example.expection.MyRuntimeException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 15:05
 * @version:1.0
 */
@RestControllerAdvice
public class MyGlobalExceptionAdvice {

    /**
     * <h2>对 MyRuntimeException 进行统一处理</h2>
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(value = MyRuntimeException.class)
    public MyResponse handlerMyException(HttpServletRequest request, MyRuntimeException ex) {
        return MyResponse.fail(ex.getCode(), ex.getMessage());
    }
}
