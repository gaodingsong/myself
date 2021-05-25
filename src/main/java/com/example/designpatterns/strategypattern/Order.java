package com.example.designpatterns.strategypattern;

import lombok.Data;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:01
 * @version:1.0
 */
@Data
public class Order {

    /**
     * 金额
     */
    private int amount;

    /**
     * 支付类型
     */
    private String paymentType;
}
