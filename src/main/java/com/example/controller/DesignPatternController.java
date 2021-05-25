package com.example.controller;

import com.example.designpatterns.strategypattern.IPayment;
import com.example.designpatterns.strategypattern.Order;
import com.example.designpatterns.strategypattern.PayResult;
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
public class DesignPatternController {

    @Autowired
    private ApplicationContext applicationContext;

    @Resource(name = "WechatPay")
    private IPayment iPayment;

    /**
     * 策略，模式
     * 优点：1、干掉繁琐的 if、switch 判断逻辑；2、代码优雅、可复用、可读性好；3、符合开闭原则，扩展性好、便于维护；
     * 缺点：1、策略如果很多的话，会造成策略类膨胀；2、使用者必须清楚所有的策略类及其用途；
     * @param amount
     * @param paymentType
     * @return
     */
    @GetMapping("/strategy")
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
