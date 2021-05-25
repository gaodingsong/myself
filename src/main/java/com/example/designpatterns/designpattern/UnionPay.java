package com.example.designpatterns.designpattern;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:05
 * @version:1.0
 */
@Service("UnionPay")
public class UnionPay implements IPayment{
    @Override
    public PayResult pay(Order order) {
        return new PayResult("云闪付支付成功");
    }
}
