package com.example.context;

import lombok.Data;

import java.io.Serializable;

/**
 * ServiceContextHolder
 * @param <T>
 */
@Data
public class ServiceContext<T> implements Serializable {

    private String message;

    private Integer code;

    private T data;
}
