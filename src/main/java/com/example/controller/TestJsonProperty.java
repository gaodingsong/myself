package com.example.controller;

import com.example.util.GsonUtil;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.stream.Stream;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2021/12/25 9:42 下午
 * @version:1.0
 */
public class TestJsonProperty {
    public static void main(String[] args) throws JsonProcessingException {

        Person person = new Person();
        person.name="gaodingsong";
//        Body b =new Body();
//        b.age_aaa =10;
//        b.height ="16";
//        person.body = b;
        String s = "{\"name\":\"gaodingsong\",\"body_tet\":{\"age_aaa\":10,\"height\":\"16\"}}";
//        System.out.println(s);
        String a  =s;
        ObjectMapper objectMapper = new ObjectMapper();
        Person person2 = objectMapper.readValue(a, Person.class);
        System.out.println(person2.xxcc.age);
        System.out.println(objectMapper.writeValueAsString(person2));



    }


    public static class Person {

        @JsonProperty("name")
        public String name;
        @JsonProperty("body_tet")
        public XXCC xxcc;
    }
    public static class  Body {
        @JsonProperty("age")
        public int age_aaa;
        @JsonProperty("height")
        public String height;
    }

    public static class  XXCC {
        @JsonProperty("age_aaa")
        public int age;
        @JsonProperty("height")
        public String height;
    }
}

