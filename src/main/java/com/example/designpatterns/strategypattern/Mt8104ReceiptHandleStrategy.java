package com.example.designpatterns.strategypattern;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:08 下午
 * @version:1.0
 */
public class Mt8104ReceiptHandleStrategy implements IReceiptHandleStrategy{
    @Override
    public void handleReceipt(Receipt receipt) {
        System.out.println("解析报文MT8104:" + receipt.getMessage());
    }
}
