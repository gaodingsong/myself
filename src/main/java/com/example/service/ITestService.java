package com.example.service;

import com.example.entity.Test;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-17
 */
public interface ITestService extends IService<Test> {

    void test1();

    void testRedis();
    void testRedis2();
    void testRedis3();

    void testQuery(int id );

    void test5();
    void test6();

}
