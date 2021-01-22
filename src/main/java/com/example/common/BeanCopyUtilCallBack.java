package com.example.common;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/1/22 17:02
 * @version:1.0
 */
@FunctionalInterface
public interface BeanCopyUtilCallBack  <S, T>{
    /**
     * 定义默认回调方法
     * @param t
     * @param s
     */
    void callBack(S t, T s);
}
