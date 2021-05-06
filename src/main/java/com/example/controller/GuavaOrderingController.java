package com.example.controller;

import cn.hutool.json.JSON;
import com.example.entity.linux1.FilterConditionTO;
import com.example.entity.linux1.PlatformRequestParamTO;
import com.example.util.GsonUtil;
import com.google.common.collect.Lists;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/4/23 11:35
 * @version:1.0
 */
public class GuavaOrderingController {
    public static void main(String[] args) {
//        Ordering<Comparable> natural = Ordering.natural();
//        Ordering.usingToString();
//        Ordering<Integer> from = Ordering.from((Integer x, Integer y) -> Ints.compare(x, y));
//        System.out.println(from.max(5, 6));
//        Ordering<Comparable> natural = Ordering.natural();
//        ArrayList<String> strings = Lists.newArrayList( "ccc","a", "as", "c", "d");
//        natural.nullsFirst();
//
//        Collections.sort(strings,natural.nullsLast()); //使用排序器对集合排序
//        natural.greatestOf(strings,3).forEach(x-> System.out.println(x)); //9

        PlatformRequestParamTO paramTO = new PlatformRequestParamTO();



        List<FilterConditionTO> filters = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            FilterConditionTO filterConditionTO = new FilterConditionTO();
            filterConditionTO.setName("nickName");
            filterConditionTO.setFilterType("EQ");
            filterConditionTO.setFilterValue(Lists.newArrayList());
            filters.add(filterConditionTO);
        }
        paramTO.setFilters(filters);

        HttpHeaders headers = new HttpHeaders();
        //定义请求参数类型，这里用json所以是MediaType.APPLICATION_JSON
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", "Bearer " );

//        HttpEntity<String> request = new HttpEntity<>(JSON.toJSONString(paramTO), headers);
////        HttpEntity<String> request = new HttpEntity<>(GsonUtil.toJsonNotContainNull(paramTO), headers);
//
//        System.out.println(request);


    }
}
