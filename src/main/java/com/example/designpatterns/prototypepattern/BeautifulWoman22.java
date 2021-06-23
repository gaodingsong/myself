package com.example.designpatterns.prototypepattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.*;
import java.util.List;

/**
 * 原型模式
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/31 16:51
 * @version:1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BeautifulWoman22 {

    private String name;

    private float height;
    private float weight;
    private float bust;
    private String character;
    private List<String> task;



}
