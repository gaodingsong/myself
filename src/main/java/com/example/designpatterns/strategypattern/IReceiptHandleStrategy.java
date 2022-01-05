package com.example.designpatterns.strategypattern;

/**
 * @author:gaodingsong
 * @description:回执处理策略接口
 * @createTime:2022/1/5 3:06 下午
 * @version:1.0
 */
public interface IReceiptHandleStrategy {

    void handleReceipt(Receipt receipt);
}
