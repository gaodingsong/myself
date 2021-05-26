package com.example.core;

import com.example.common.MyResponse;
import com.example.constant.ErrorConstant;
import com.example.enumeration.ResponseStatus;
import com.example.expection.MyRuntimeException;
import com.example.util.GsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/26 14:30
 * @version:1.0
 */
public interface BaseService {
    Logger LOGGER = LoggerFactory.getLogger(BaseService.class);


    /**
     * 调用服务基类
     *
     * @param function
     * @param param
     * @param methodName
     * @param <T>
     * @param <R>
     * @return
     */
    default <T, R> MyResponse<R> doService(Function<T, R> function, T param, String methodName) {
        TraceLogUtils.genTracgId();
        LOGGER.info("【myself】request method:【{}】,param:【{}】", methodName, GsonUtil.toJsonContainNull(param));
        ServiceContextHolder.createEmptyContext();
        R result;
        try {
            result = function.apply(param);
            return getGqResponse(result);
        } catch (MyRuntimeException e) {
            LOGGER.error("【myself】request method{},request param error: {}--{}", methodName, e.getCode(), e.getMessage());
            return MyResponse.fail(e.getCode(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(String.format(ErrorConstant.GLOBAL_ERROR_FORMAT, methodName, GsonUtil.toJsonContainNull(param)), e);
            return MyResponse.fail(ResponseStatus.FAIL.getCode(), e.getMessage());
        } finally {
            ServiceContextHolder.clean();
            TraceLogUtils.removeTraceId();
        }

    }

    /**
     * 调用服务无参
     */
    default <T> MyResponse<T> doServiceNoArg(Supplier<T> supplier, String methodName) {
        TraceLogUtils.genTracgId();
        LOGGER.info("【myself】request method【{}】", methodName);
        ServiceContextHolder.createEmptyContext();
        T result;
        try {
            result = supplier.get();
            return getGqResponse(result);
        } catch (MyRuntimeException e) {
            LOGGER.error("【myself】request method【{}】,request param error: {}--{}", methodName, e.getCode(), e.getMessage());
            return MyResponse.fail(e.getCode(), e.getMessage());
        } catch (Exception e) {
            LOGGER.error(String.format(ErrorConstant.GLOBAL_ERROR_FORMAT, methodName, CommonConstant.EMPTY_STRING), e);
            return MyResponse.fail(ResponseStatus.FAIL.getCode(), e.getMessage() + CommonConstant.EMPTY_STRING);
        } finally {
            ServiceContextHolder.clean();
            TraceLogUtils.removeTraceId();
        }
    }

    default <T> MyResponse<T> getGqResponse(T result) {
        if (result != null) {
            return MyResponse.succ(result);
        }
        ServiceContext context = ServiceContextHolder.getCurrentContext();
        if (context.getCode() != null) {
            return MyResponse.fail(context.getCode(), context.getMessage());
        }
        return MyResponse.fail(context.getMessage());
    }






}
