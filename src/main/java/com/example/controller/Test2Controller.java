package com.example.controller;


import com.example.enumeration.SexEnum;
import com.example.model.vo.user.UserDO;
import com.example.model.vo.user.UserVO2;
import com.example.util.BeanCopyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@Slf4j
@RestController
@RequestMapping("/test2")
public class Test2Controller {


    public static void main(String[] args) {

        List<UserDO> userDOList = new ArrayList();
        userDOList.add(new UserDO(1L, "Van", 18, 1));
        userDOList.add(new UserDO(2L, "VanVan", 20, 2));
//        List<UserVO2> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO2::new);
//        log.info("userVOList:{}",userVOList);
//



        List<UserVO2> userVOList = BeanCopyUtil.copyListProperties(userDOList, UserVO2::new, (userDO, userVO) ->{
            // 这里可以定义特定的转换规则
            userVO.setSex(SexEnum.getDescByCode(userDO.getSex()).getDesc());
        });
        log.info("userVOList:{}",userVOList);


    }

}
