package com.example.designpatterns.strategypattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2022/1/5 3:04 下午
 * @version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Receipt {

    /**
     * 回执信息
     */
    String message;

    /**
     * 回执类型(`MT1101、MT2101、MT4101、MT8104、MT8105、MT9999`)
     */
    String type;

}
