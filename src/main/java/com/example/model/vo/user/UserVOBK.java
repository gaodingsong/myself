package com.example.model.vo.user;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2020/11/26 17:06
 * @version:1.0
 */
@Data
@ApiModel(description = "用户信息")
public class UserVOBK implements Serializable {


    @ExcelProperty(value = "用户名称", index = 0)
    private String name;

    @ExcelProperty(value = "用户头像", index = 1)
    private String headimg;

    @ExcelProperty(value = "性别，0：未知 ，1：男 ，2：女", index = 2)
    private Integer gender;

    @ExcelProperty(value = "生日", index = 3)
    private LocalDate birthday;

    @ExcelProperty(value = "用户密码", index = 4)
    private String password;

    @ExcelProperty(value = "手机号", index = 5)
    private String phone;

    @ExcelProperty(value = "邮箱", index = 6)
    private String mail;

}
