package com.example.service;

import com.example.entity.linux1.Test;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
public interface ITestService extends IService<Test> {

    Integer test();

    String test666(String stt);

    void testThreadLocal();

    List<Test> selectAll();

}
