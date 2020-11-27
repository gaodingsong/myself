package com.example.controller;


import com.example.common.MyResponse;
import com.example.entity.Test2;
import com.example.enumeration.ErrorTypeEnum;
import com.example.service.ITest2Service;
import com.example.validation.InputCheckUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2020-11-19
 */
@RestController
@RequestMapping("/test2")
public class Test2Controller {


    @Autowired
    private ITest2Service test2Service;

    @GetMapping("/test")
    public void test(){
        test2Service.test5();
    }

    @PostMapping("/testValidator")
    public MyResponse testValidator(@RequestBody  Test2 test2){

//        if (test2.getAge()<0){
//            throw new MyRuntimeException(100,"年龄不合法");
//        }

        // 先校验参数是否为空
        InputCheckUtil checkUtil = InputCheckUtil
                .checker()
                .checkNullStr(test2.getName(), ErrorTypeEnum.CATEGORY_NAME)

                ;
        System.out.println(test2);
        return  MyResponse.succ(test2);

    }


}
