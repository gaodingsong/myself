package com.example.entity.linux1;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotBlank(message = "名称不能为空")
    @ApiModelProperty(value = "兑换编码")
    @Size(max = 10,message = "不能超过10个字符")
    private String name;

    private Integer age;

    private Integer sex;


}
