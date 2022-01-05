package com.example.designpatterns.strategypattern;


import java.util.HashMap;
import java.util.Map;

/**
 * @author:gaodingsong
 * @description:策略工厂
 * @createTime:2022/1/5 3:10 下午
 * @version:1.0
 */
public class ReceiptHandleStrategyFactory {



    private static Map<String,IReceiptHandleStrategy> receiptHandleStrategyMap = new HashMap<>();

    static {
        receiptHandleStrategyMap.put("MT2101",new Mt2101ReceiptHandleStrategy());
        receiptHandleStrategyMap.put("MT8104",new Mt8104ReceiptHandleStrategy());
    }

    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
        return receiptHandleStrategyMap.get(receiptType);
    }

    public static void main(String[] args) {
        IReceiptHandleStrategy mt2101 = new ReceiptHandleStrategyFactory().getReceiptHandleStrategy("MT2101");
        System.out.println(mt2101);

    }

//    private ReceiptHandleStrategyFactory(){}
//
//    public static IReceiptHandleStrategy getReceiptHandleStrategy(String receiptType){
//        IReceiptHandleStrategy receiptHandleStrategy = null;
//        if (StringUtils.equals("MT2101",receiptType)) {
//            receiptHandleStrategy = new Mt2101ReceiptHandleStrategy();
//        } else if (StringUtils.equals("MT8104",receiptType)) {
//            receiptHandleStrategy = new Mt8104ReceiptHandleStrategy();
//        }
//        return receiptHandleStrategy;
//    }
}
