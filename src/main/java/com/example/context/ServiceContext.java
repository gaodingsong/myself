package com.example.context;

import lombok.Data;

import java.io.Serializable;

/**
 * @author majiawei
 * @classname ServiceContext
 * @desc
 * @date create in 2020/7/24 14:24
 */
@Data
public class ServiceContext<T> implements Serializable {

    private String message;

    private Integer code;

    private T data;
}
