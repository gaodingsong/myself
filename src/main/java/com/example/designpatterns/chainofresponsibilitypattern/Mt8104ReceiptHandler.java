package com.example.designpatterns.chainofresponsibilitypattern;

import com.alibaba.druid.util.StringUtils;
import com.example.designpatterns.strategypattern.Receipt;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:44 下午
 * @version:1.0
 */
public class Mt8104ReceiptHandler implements IReceiptHandler {

    @Override
    public void handleReceipt(Receipt receipt, IReceiptHandleChain handleChain) {
        if (StringUtils.equals("MT8104",receipt.getType())) {
            System.out.println("解析报文MT8104:" + receipt.getMessage());
        }
        //处理不了该回执就往下传递
        else {
            handleChain.handleReceipt(receipt);
        }
    }
}
