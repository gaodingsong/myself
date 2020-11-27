package com.example.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 13:56
 * @version:1.0
 */
@AllArgsConstructor
public enum ErrorTypeEnum {

    /**
     * 参数错误
     */
    PARAM_ERROR(10001, "参数错误"),
    VALIDATE_NAME_LENGTH(10004,"请输入1-30位名称"),
    VALIDATE_ACCOUNT(10018,"账户余额不能为空"),
    CATEGORY_NAME(10030,"分类名称不能为null"),
    VALIDATE_GRADE_NAME(10033,"等级名称输入不合法嗨"),
    IS_GRADE_CODE(10034,"等级编码不能输入小于1长度等于两位的正整数鸭"),
    IS_GRADE_UP_HP(10035,"成长值只能输入大于0长度在7位以内的正整数鸭")
    ;


    @Getter
    private Integer code;
    @Getter
    private String message;

}
