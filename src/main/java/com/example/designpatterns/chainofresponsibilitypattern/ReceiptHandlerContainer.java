package com.example.designpatterns.chainofresponsibilitypattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:41 下午
 * @version:1.0
 */
public class ReceiptHandlerContainer {

    private ReceiptHandlerContainer(){}

    public static List<IReceiptHandler> getReceiptHandlerList(){
        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
        receiptHandlerList.add(new Mt2101ReceiptHandler());
        receiptHandlerList.add(new Mt8104ReceiptHandler());
        return receiptHandlerList;
    }

}
