package com.example.service;

import com.example.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.vo.user.UserVO;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-26
 */
public interface IUserService extends IService<User> {

    void saveUser(UserVO user);
}
