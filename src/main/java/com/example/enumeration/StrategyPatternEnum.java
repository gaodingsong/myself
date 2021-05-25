package com.example.enumeration;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 16:35
 * @version:1.0
 */
public enum StrategyPatternEnum {
    Alipay(1,"Alipay"),
    WechatPay(2,"WechatPay"),
    UnionPay(3,"UnionPay");

    private String desc;
    private int code;

    StrategyPatternEnum(int code, String desc) {
        this.desc = desc;
        this.code = code;
    }

    public static StrategyPatternEnum getDescByCode(int code) {
        StrategyPatternEnum[] typeEnums = values();
        for (StrategyPatternEnum value : typeEnums) {
            if (code == value.getCode()) {
                return value;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
