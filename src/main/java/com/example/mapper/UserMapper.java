package com.example.mapper;

import com.example.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.model.vo.user.LoginVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-26
 */
public interface UserMapper extends BaseMapper<User> {

    User loginByPhoneAndPassword(@Param("loginVO") LoginVO loginVO);
}
