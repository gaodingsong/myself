package com.example.entity;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.mail.MailUtil;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-17
 */
@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;



    public Test age(int age){
        this.age = age;
        return this;
    }

    public Test sex(int age){
        this.sex = sex;
        return this;
    }


    public Test name(String name){
        this.name = name;
        return this;
    }
    public static void main(String[] args) {
        Test build = Test.builder()
                .age(20)
                .sex(1)
                .name("测试")
                .build();
        System.out.println(build);

        String str = "2020-09-24 23:03:46";
        Date date = DateUtil.parse(str, "yyyy-MM-dd HH:mm:ss");
        long time = date.getTime();
        System.out.println(time);


    }


}
