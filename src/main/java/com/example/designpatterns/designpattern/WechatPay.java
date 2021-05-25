package com.example.designpatterns.designpattern;

import org.springframework.stereotype.Service;

/**
 * @description:定义微信支付策略
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:03
 * @version:1.0
 */
@Service("WechatPay")
public class WechatPay implements IPayment{

    @Override
    public PayResult pay(Order order) {
        return new PayResult("微信支付成功");
    }
}
