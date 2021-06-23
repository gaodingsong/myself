package com.example.designpatterns.prototypepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/31 16:56
 * @version:1.0
 */
public class Client {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("做饭");
        list.add("洗衣服");
        BeautifulWoman prototypeBeautifulWoman = new BeautifulWoman("小美",170F,55F,90F,"漂亮，性格火爆",list);

        BeautifulWoman cloneBeautifulWoman = prototypeBeautifulWoman.deepClone();
        cloneBeautifulWoman.setName("小红");
        cloneBeautifulWoman.setCharacter("漂亮，性格温柔");
        cloneBeautifulWoman.getTask().add("按摩洗脚");

        System.out.println("原女朋友："+prototypeBeautifulWoman);
        System.out.println("现女朋友："+cloneBeautifulWoman);


    }
}
