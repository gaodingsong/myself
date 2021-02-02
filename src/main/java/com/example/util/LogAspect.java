package com.example.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/2/2 13:37
 * @version:1.0
 */
@Aspect
@Component
@Slf4j
public class LogAspect {


    @Pointcut("execution( public * com.example.controller.*.*(..))")
    public void cut(){}

    @Around("cut()")
    public Object recordLogs(ProceedingJoinPoint pjp){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        String username="";

        Object proceed = null;
        try {

            String method = request.getMethod();
            StringBuffer requestURL = request.getRequestURL();

            // 方法参数
//            Map<String, Object> nameAndValue = getNameAndValue(pjp);
            System.out.println(request);
            proceed = pjp.proceed();  //执行连接点方法，object：方法返回值
            System.out.println(proceed);
            //方法后
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceed;
    }




    /**
     * 获取参数Map集合
     * @param joinPoint
     * @return
     */
    Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {
        Map<String, Object> param = new HashMap<>();

        Object[] paramValues = joinPoint.getArgs();
        String[] paramNames = ((CodeSignature)joinPoint.getSignature()).getParameterNames();

        for (int i = 0; i < paramNames.length; i++) {
            param.put(paramNames[i], paramValues[i]);
        }

        return param;
    }

}
