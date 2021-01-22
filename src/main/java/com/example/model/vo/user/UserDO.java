package com.example.model.vo.user;

import lombok.Data;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/1/22 17:10
 * @version:1.0
 */
@Data
public class UserDO {
    private Long userId;
    private String userName;
    private Integer age;
    private Integer sex;
    public UserDO() {

    }

    public UserDO(Long userId, String userName, Integer age, Integer sex) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.sex = sex;
    }
}
