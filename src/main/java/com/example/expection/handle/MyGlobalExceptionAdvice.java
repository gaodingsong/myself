package com.example.expection.handle;

import com.example.common.MyResponse;
import com.example.expection.MyRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public String paramExceptionHandler(MethodArgumentNotValidException e){
        BindingResult exceptions = e.getBindingResult();
        // 判断异常中是否有错误信息，如果存在就使用异常中的消息，否则就适用默认消息
        if (exceptions.hasErrors()){
            List<ObjectError> allErrors = exceptions.getAllErrors();
            if (!allErrors.isEmpty()){
                // 这里列出了全部错误参数，按照正常逻辑，只需要看第一条错误即可
                FieldError fieldError = (FieldError)allErrors.get(0);
                return fieldError.getDefaultMessage();

            }
        }
        return "请求参数错误";
    }
}
