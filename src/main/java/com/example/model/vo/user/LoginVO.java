package com.example.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:49
 * @version:1.0
 */
@Data
@ApiModel(description = "登录")
public class LoginVO {
    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;
}
