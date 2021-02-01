package com.example.controller;


import com.example.enumeration.ErrorTypeEnum;
import com.example.expection.MyRuntimeException;
import com.example.handler.HandlerAdapter;
import com.example.handler.TypeHandler;
import com.example.model.vo.user.UserVO;
import com.example.model.vo.user.UserVOBK;
import com.example.service.ITestService;
import com.example.util.ExcelHelper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

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
public class TestController {

    @Autowired
    private ITestService testService1;


    @Autowired
    private HandlerAdapter HandlerAdapter;

//    @Autowired
//    private ITest2Service test2Service2;


    @Autowired
    private ExcelHelper excelHelper;

    @GetMapping("test")
    public void test(){
        testService1.test();
    }

    @GetMapping("/test2")
    public  String test2(){
        try {
            int a = 10/0;
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
        boolean text = StringUtils.hasText(" ");
        System.out.println(text);
        boolean b = StringUtils.hasLength(null);

        System.out.println(b);

    }
}
