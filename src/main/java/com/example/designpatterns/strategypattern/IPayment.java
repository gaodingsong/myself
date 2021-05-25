package com.example.designpatterns.strategypattern;

/**
 * @description:策略模式接口
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:00
 * @version:1.0
 */

/**
 * 支付接口
 * 定义策略接口
 */

public interface IPayment {
    /**
     * 支付
     * @param order
     * @return
     */
    PayResult pay(Order order);
}
