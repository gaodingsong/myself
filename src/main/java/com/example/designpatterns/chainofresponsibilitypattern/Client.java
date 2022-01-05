package com.example.designpatterns.chainofresponsibilitypattern;

import com.example.designpatterns.strategypattern.Receipt;
import com.example.designpatterns.strategypattern.ReceiptBuilder;

import java.util.List;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:45 下午
 * @version:1.0
 */
public class Client {
    public static void main(String[] args) {
        //模拟回执
        List<Receipt> receiptList = ReceiptBuilder.generateReceiptList();
        for (Receipt receipt : receiptList) {
            //回执处理链对象
            ReceiptHandleChain receiptHandleChain = new ReceiptHandleChain();
            receiptHandleChain.handleReceipt(receipt);
        }
    }
}
