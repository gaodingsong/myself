package com.example.controller;

import com.example.common.MyResponse;
import com.example.constant.CommonConstant;
import com.example.entity.linux1.Test;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @description:
 * @author:dingsong.gao
 * @createTime:2021/5/19 15:12
 * @version:1.0
 */
@RestController
@RequestMapping("/vaildParam")
public class VaildParamController {


    @ApiOperation(httpMethod = "POST", value = "新增", notes = "新增")
    @PostMapping(value = "/add")
    @ResponseBody
    public MyResponse add(@RequestBody @Valid Test test, BindingResult bindingResult){

        MyResponse error = validParam(bindingResult);
        if (error != null) {return error;}
        return null;
    }

    private MyResponse validParam(BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return MyResponse.fail(CommonConstant.ERROR_CODE,bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return null;
    }

}
