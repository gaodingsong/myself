package com.example.controller;

import com.example.entity.User;
import com.example.model.vo.user.LoginVO;
import com.example.service.ILoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:41
 * @version:1.0
 */
@Slf4j
@RestController
@RequestMapping("login")
@Api(value = "登录接口", tags = "登录接口")
public class LoginController {

    @Autowired
    private ILoginService loginService;


    @ApiOperation(httpMethod = "POST", value = "登录", notes = "登录", produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping("login")
    public String login(LoginVO loginVO){
        String token = loginService.login(loginVO);
        return token;

    }


}
