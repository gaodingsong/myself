package com.example.service;

import com.example.model.vo.user.LoginVO;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:42
 * @version:1.0
 */
public interface ILoginService {
    String login(LoginVO loginVO);
}
