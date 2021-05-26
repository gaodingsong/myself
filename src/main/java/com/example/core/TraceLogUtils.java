package com.example.core;

import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/26 14:31
 * @version:1.0
 */
public class TraceLogUtils {
    private static final ThreadLocal<String> traceIdLocal = new ThreadLocal();

    public TraceLogUtils() {
    }

    public static String getTraceId() {
        String traceId = (String)traceIdLocal.get();
        return null == traceId ? "" : traceId;
    }

    public static String genTracgId() {
        traceIdLocal.remove();
        String traceId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
        traceIdLocal.set(traceId);
        return traceId;
    }

    public static String genTracgIdIfNotExist() {
        if (StringUtils.isNotBlank((CharSequence)traceIdLocal.get())) {
            return (String)traceIdLocal.get();
        } else {
            traceIdLocal.remove();
            String traceId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);
            traceIdLocal.set(traceId);
            return traceId;
        }
    }

    public static void removeTraceId() {
        traceIdLocal.remove();
    }

    public static void genTracgId(String traceId) {
        if (StringUtils.isBlank(traceId)) {
            genTracgId();
        } else {
            traceIdLocal.remove();
            traceIdLocal.set(traceId);
        }
    }
}
