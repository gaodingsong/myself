package com.example.controller;

import com.example.designpatterns.designpattern.IPayment;
import com.example.designpatterns.designpattern.Order;
import com.example.designpatterns.designpattern.PayResult;
import com.example.enumeration.StrategyPatternEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:策略模式控制器
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:07
 * @version:1.0
 */
@RestController
@Controller("/design/pattern")
public class StrategPatternController {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource(name = "WechatPay")
    private IPayment iPayment;

    @GetMapping("/pay")
    public PayResult pay(@RequestParam("amount") int amount,
                         @RequestParam("paymentType") int paymentType) {
        Order order = new Order();
        order.setAmount(amount);

        order.setPaymentType(StrategyPatternEnum.getDescByCode(paymentType).getDesc());


        // 根据支付类型获取对应的策略 bean
        IPayment payment = applicationContext.getBean(order.getPaymentType(), IPayment.class);

        // 开始支付
        PayResult payResult = payment.pay(order);


        return payResult;
    }
}
