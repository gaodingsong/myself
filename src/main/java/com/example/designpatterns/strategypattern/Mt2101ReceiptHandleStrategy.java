package com.example.designpatterns.strategypattern;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:07 下午
 * @version:1.0
 */
public class Mt2101ReceiptHandleStrategy implements IReceiptHandleStrategy{
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT2101:" + receipt.getMessage());
    }
}
