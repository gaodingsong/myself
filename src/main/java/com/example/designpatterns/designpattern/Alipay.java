package com.example.designpatterns.designpattern;

import org.springframework.stereotype.Service;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:05
 * @version:1.0
 */
@Service("Alipay")
public class Alipay implements IPayment{
    @Override
    public PayResult pay(Order order) {
        return new PayResult("支付宝支付成功");
    }
}
