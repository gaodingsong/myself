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
public class BeautifulWoman implements Cloneable, Serializable {

    private String name;

    private float height;
    private float weight;
    private float bust;
    private String character;
    private List<String> task;


    @Override
    protected BeautifulWoman clone(){
        BeautifulWoman beautifulWoman = null;
        try {
             beautifulWoman = (BeautifulWoman) super.clone();
        }catch (Exception e){

            e.printStackTrace();
        }
        return beautifulWoman;
    }


    protected BeautifulWoman deepClone(){

        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(stream);
            objectOutputStream.writeObject(this);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stream.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
             return (BeautifulWoman)objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;

    }





}
