package com.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.Test2;
import com.example.mapper.Test2Mapper;
import com.example.service.ITest2Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-19
 */
@Service
public class Test2ServiceImpl extends ServiceImpl<Test2Mapper, Test2> implements ITest2Service {

    @Autowired
    private Test2Mapper mapper;

    @Override
    @DS("db2")
    public void test5() {

        List<Test2> test2s = mapper.selectList(new QueryWrapper<>());

        for (Test2 test2 : test2s) {
            System.out.println(test2);
        }
    }
}
