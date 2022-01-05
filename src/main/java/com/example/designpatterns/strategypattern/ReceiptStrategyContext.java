package com.example.designpatterns.strategypattern;

/**
 * @author:gaodingsong
 * @description:上下文类，持有策略接口
 * @createTime:2022/1/5 3:09 下午
 * @version:1.0
 */
public class ReceiptStrategyContext {

    private IReceiptHandleStrategy receiptHandleStrategy;
    /**
     * 设置策略接口
     * @param receiptHandleStrategy
     */
    public void setReceiptHandleStrategy(IReceiptHandleStrategy receiptHandleStrategy) {
        this.receiptHandleStrategy = receiptHandleStrategy;
    }

    public void handleReceipt(Receipt receipt){
        if (receiptHandleStrategy != null) {
            receiptHandleStrategy.handleReceipt(receipt);
        }
    }
}
