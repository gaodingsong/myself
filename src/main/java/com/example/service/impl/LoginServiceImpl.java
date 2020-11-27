package com.example.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.model.vo.user.LoginVO;
import com.example.service.ILoginService;
import com.example.util.GsonUtil;
import com.example.util.UuidUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:43
 * @version:1.0
 */
@Slf4j
@Service
public class LoginServiceImpl implements ILoginService {
    @Autowired
    private UserMapper userMapper;


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public String login(LoginVO loginVO) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("phone",loginVO.getPhone());
        queryWrapper.eq("password",loginVO.getPassword());
        User user = userMapper.selectOne(queryWrapper);
//        User user = userMapper.loginByPhoneAndPassword(loginVO);

          if (null != user){
              String uuid = UuidUtil.uuid();
              redisTemplate.opsForValue().set(uuid, GsonUtil.toJsonContainNull(user),60L,TimeUnit.SECONDS);
              return uuid;
          }

        return null;
    }


    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString());
    }
}
