package com.example.designpatterns.strategypattern;

import java.util.List;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:11 下午
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        //模拟回执
        List<Receipt> receiptList = ReceiptBuilder.generateReceiptList();
        //策略上下文
        ReceiptStrategyContext receiptStrategyContext = new ReceiptStrategyContext();
        for (Receipt receipt : receiptList) {
            //获取并设置策略
            IReceiptHandleStrategy receiptHandleStrategy = ReceiptHandleStrategyFactory.getReceiptHandleStrategy(receipt.getType());
            receiptStrategyContext.setReceiptHandleStrategy(receiptHandleStrategy);
            //执行策略
            receiptStrategyContext.handleReceipt(receipt);
        }
    }
}
