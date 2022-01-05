package com.example.designpatterns.chainofresponsibilitypattern;

import com.example.designpatterns.strategypattern.Receipt;

/**
 * @author:gaodingsong
 * @description:责任链接口
 * @createTime:2022/1/5 3:32 下午
 * @version:1.0
 */
public interface IReceiptHandleChain {
    void handleReceipt(Receipt receipt);
}
