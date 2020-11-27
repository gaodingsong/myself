package com.example.controller;


import com.example.common.MyResponse;
import com.example.entity.User;
import com.example.model.vo.user.UserVO;
import com.example.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-26
 */
@Slf4j
@RestController
@RequestMapping("user")
@Api(value = "用户信息", tags = "用户信息")
public class UserController {

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Autowired
    private IUserService userService;

    @ApiOperation(httpMethod = "POST", value = "保存用户", notes = "保存用户", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("saveUser")
    public MyResponse saveUser(@RequestBody UserVO user){
        userService.saveUser(user);
        return MyResponse.succ();
    }

}
