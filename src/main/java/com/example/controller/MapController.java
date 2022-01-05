package com.example.controller;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:gaodingsong
 * @description:
 * @createTime:2021/12/19 3:41 下午
 * @version:1.0
 */
public class MapController {

    public static void main(String[] args) throws IOException {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        map.computeIfAbsent("广东", k -> new ArrayList<String>());
        System.out.println(map);

        // 定义一个全局的配置文件xml文件
        String resource ="mybatis.xml";
        // 把配置文件翻译成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 解析全局的配置文件 生成一个sqlSessionFactory  是一个工厂，这个工厂负责生产sqlSession，sqlSession就是表示为一个数据库连接
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
//        // 这里就是去执行sql了
//        User user = mapper.selectById(1);
//        sqlSession.commit();
//        sqlSession.flushStatements();
//        sqlSession.close();

    }
}
