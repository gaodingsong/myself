package com.example.controller;


import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.example.common.MyResponse;
import com.example.core.BaseService;
import com.example.entity.linux1.Test;
import com.example.enumeration.ErrorTypeEnum;
import com.example.expection.MyRuntimeException;
import com.example.handler.HandlerAdapter;
import com.example.handler.TypeHandler;
import com.example.model.vo.user.UserVO;
import com.example.model.vo.user.UserVOBK;
import com.example.service.ITestService;
import com.example.util.ExcelHelper;
import com.example.validation.PreCheckUtil;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gaodingsong
 * @since 2021-01-08
 */
@RestController
@Controller("/test")
public class TestController implements BaseService {

    @Autowired
    private ITestService testService1;


    @Autowired
    private HandlerAdapter HandlerAdapter;

//    @Autowired
//    private ITest2Service test2Service2;


    @Autowired
    private ExcelHelper excelHelper;

    @GetMapping("test")
    public MyResponse test(){
        return doServiceNoArg(testService1::test,"test");


    }


    @GetMapping("test666")
    public MyResponse test666(String str){
        return doService(testService1::test666,str,"test666");
    }

    @GetMapping("/test2")
    public  String test2(){
        try {

            Integer a = null;
            String str = "adfa";
            PreCheckUtil.checker().checkNull(a,ErrorTypeEnum.PARAM_ERROR)
                    .checkNull(str,ErrorTypeEnum.PARAM_ERROR);

            System.out.println(str);
        } catch (Exception e) {
            throw new MyRuntimeException(ErrorTypeEnum.PARAM_ERROR.getCode(), ErrorTypeEnum.PARAM_ERROR.getMessage());
        }
        return "nihao";
    }




    /**
     * 导出excel
     *
     * @return
     */
    @GetMapping("/users/export")
    public void exportUser( HttpServletResponse response) throws IOException {
        List<UserVOBK> result = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            UserVOBK vo = new UserVOBK();
            vo.setName("test Export "+ i);
            vo.setGender(1);
            vo.setPassword(13456+"|");
            vo.setPhone("155156225521");
            result.add(vo);

        }
        //导出操作
        try {
            excelHelper.writeExcel(response, result, "会员信息", "sheet",
                    UserVOBK.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("成功");
    }

    @GetMapping("/tttt")
    public void tttt(String str){
        HandlerAdapter.handle(str,str);
    }


    public static void main(String[] args) {
        //  判断是否是空字符串
        boolean text = StringUtils.hasText(null);
        System.out.println("hasText:"+text);
        boolean b = StringUtils.hasLength(" ");

        System.out.println("hasLength:"+b);


    }

    @GetMapping("/testValid")
    public void testValid( @Validated @RequestBody Test t){
        System.out.println(t);

    }
}
