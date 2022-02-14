package com.example.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.context.ServiceContextHolder;
import com.example.entity.linux1.Test;
import com.example.entity.linux2.Test2;
import com.example.mapper.linux1.TestMapper;
import com.example.mapper.linux2.Test2Mapper;
import com.example.service.ITestService;
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
 * @since 2021-01-08
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Autowired
    private Test2Mapper test2Mapper2;

    @Override
//    @DS("db2")
    public Integer test() {
//        Test test = testMapper.test1(1);
////        Test2 test = test2Mapper2.selectById(5);
//        Test2 test2 = test2Mapper2.test2(5);
//        System.out.println(test+","+test2);

        return 21;
    }

    @Override
    public String test666(String stt) {
        return "aaaaaaaaaaaaaa";
    }

    @Override
    public void testThreadLocal() {
        try {
            String a  = (String) ServiceContextHolder.getCurrentContext().getData();
            System.out.println(a);
        }finally {
            ServiceContextHolder .clean();
        }

        System.out.println(12);
    }

    @Override
    public List<Test> selectAll() {
        return testMapper.selectAll();
    }
}
