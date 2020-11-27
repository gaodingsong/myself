package com.example.model.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:06
 * @version:1.0
 */
@Data
@ApiModel(description = "用户信息")
public class UserVO {

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "用户头像")
    private String headimg;

    @ApiModelProperty(value = "性别，0：未知 ，1：男 ，2：女")
    private Integer gender;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String mail;

}
