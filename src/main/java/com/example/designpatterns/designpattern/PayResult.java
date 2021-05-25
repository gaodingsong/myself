package com.example.designpatterns.designpattern;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:02
 * @version:1.0
 */
@Data
@AllArgsConstructor
public class PayResult {
    /**
     * 支付结果
     */
    private String result;
}
