package com.example.designpatterns.adapterpattern;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 18:20
 * @version:1.0
 */
public interface TypeHandler {

    boolean isMatched(String... type);

    void handle(Object obj);
}
