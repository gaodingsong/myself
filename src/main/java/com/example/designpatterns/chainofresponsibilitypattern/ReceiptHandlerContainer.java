package com.example.designpatterns.chainofresponsibilitypattern;

import com.example.util.ReflectionUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:41 下午
 * @version:1.0
 */
public class ReceiptHandlerContainer {

//    private ReceiptHandlerContainer(){}
//
//    public static List<IReceiptHandler> getReceiptHandlerList(){
//        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
//        receiptHandlerList.add(new Mt2101ReceiptHandler());
//        receiptHandlerList.add(new Mt8104ReceiptHandler());
//        return receiptHandlerList;
//    }


    private ReceiptHandlerContainer(){}

    public static List<IReceiptHandler> getReceiptHandlerList(){
        List<IReceiptHandler> receiptHandlerList = new ArrayList<>();
        //获取IReceiptHandler接口的实现类
        Set<Class<?>> classList = ReflectionUtil.getClassSetBySuper(IReceiptHandler.class);
        if (classList != null && classList.size() > 0) {
            for (Class<?> clazz : classList) {
                try {
                    receiptHandlerList.add((IReceiptHandler)clazz.newInstance());
                } catch ( Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return receiptHandlerList;
    }


}
