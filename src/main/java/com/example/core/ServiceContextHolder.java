package com.example.core;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/26 14:32
 * @version:1.0
 */
public class ServiceContextHolder {

    private final static ThreadLocal<ServiceContext> context = new ThreadLocal<>();

    private ServiceContextHolder(){}

    public static void createEmptyContext(){
        context.set(new ServiceContext());
    }

    public static ServiceContext getCurrentContext(){
        return context.get();
    }

    public static void clean(){
        context.remove();
    }

    public static void failMsg(Integer code, String msg){
        ServiceContext currentContext = getCurrentContext();
        currentContext.setCode(code);
        currentContext.setMessage(msg);
    }
}
