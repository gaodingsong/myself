package com.example.designpatterns.chainofresponsibilitypattern;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 17:40
 * @version:1.0
 */
public abstract class Handler {
    protected Handler handler;

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
    public abstract void handleRequest(Integer times);
}
