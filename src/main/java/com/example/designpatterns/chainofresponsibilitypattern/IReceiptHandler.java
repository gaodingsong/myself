package com.example.designpatterns.chainofresponsibilitypattern;

import com.example.designpatterns.strategypattern.Receipt;

/**
 * @author:gaodingsong
 * @description:抽象回执处理者接口
 * @createTime:2022/1/5 3:31 下午
 * @version:1.0
 */
public interface IReceiptHandler {

    void handleReceipt(Receipt receipt, IReceiptHandleChain handleChain);

}
