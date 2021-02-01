package com.example.handler;

/**
 * @description:适配器接口
 * @author:dingsong.gao
 * @createTime:2021/2/1 16:47
 * @version:1.0
 */
public interface TypeHandler {

    boolean isMatched(String... type);

    void handle(Object obj);
}
