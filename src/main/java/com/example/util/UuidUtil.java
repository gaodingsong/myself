package com.example.util;

import cn.hutool.core.lang.UUID;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/27 10:10
 * @version:1.0
 */
public class UuidUtil {

    public static String uuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
