package com.example.context;


/**
 * ServiceContextHolder
 * @param <T>
 */
public class ServiceContextHolder<T> {

    private final static ThreadLocal<ServiceContext> context = new ThreadLocal<>();

    private ServiceContextHolder() {
    }

    public static void createEmptyContext() {
        ServiceContext<Object> serviceContext = new ServiceContext<>();
        context.set(serviceContext);
    }

    public static ServiceContext getCurrentContext() {
        return context.get() == null ? new ServiceContext<>() : context.get();
    }

    public static ServiceContext getDefaultCurrentContext() {
        return context.get();
    }

    public static void clean() {
        context.remove();
    }

    public static void failMsg(Integer code, String msg) {
        ServiceContext currentContext = getCurrentContext();
        currentContext.setCode(code);
        currentContext.setMessage(msg);
    }

    public static <T> void success(T data) {
        ServiceContext currentContext = getDefaultCurrentContext();
        currentContext.setData(data);
    }
}
