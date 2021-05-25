package com.example.designpatterns.adapterpattern;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/25 18:20
 * @version:1.0
 */
@Component
public class HandlerAdapter2 {
    @Resource
    private List<TypeHandler> handlers;

    public void handle(Object obj, String... types) {
        for (TypeHandler handler : handlers) {
            if (handler.isMatched(types)) {
                handler.handle(obj);
            }
        }
    }

}
