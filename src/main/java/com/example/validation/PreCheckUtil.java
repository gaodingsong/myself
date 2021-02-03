package com.example.validation;


import com.example.enumeration.ErrorTypeEnum;
import com.example.expection.MyRuntimeException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 参数前置校验
 */
public class PreCheckUtil {

    private PreCheckUtil() {
    }

    private static final PreCheckUtil instance = new PreCheckUtil();

    public static PreCheckUtil checker() {
        return instance;
    }


    /**
     * 参数是否为null
     * @param t
     * @param errorTypeEnum
     * @return
     */
    public <T> PreCheckUtil checkNull( T  t, ErrorTypeEnum errorTypeEnum) {
        if (null == t){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }


    /**
     * 校验手机号是否全是数字
     * @param str
     * @return
     */
    public PreCheckUtil isNumeric(String str, ErrorTypeEnum errorTypeEnum) {
        Pattern pattern = Pattern.compile("^-?[0-9]+"); //这个也行
//       Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");//这个也行
        Matcher isNum = pattern.matcher(str);
       boolean flag = isNum.matches();
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum);
        }
        return instance;
    }

    /**
     * 判断等级名称是否是特殊符号
     * */
    public PreCheckUtil validateGradeName(String str, ErrorTypeEnum errorTypeEnum){
        Pattern p = Pattern.compile("[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？ ]");
        Matcher m = p.matcher(str);
        boolean flag = m.matches();
        if(flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), ErrorTypeEnum.VALIDATE_GRADE_NAME.getMessage());
        }
        return instance;
    }

    /**
     * 判断等级编码是否是大于0的正整数且只有两位
     * */
    public PreCheckUtil isGradeCode(String str, ErrorTypeEnum errorTypeEnum){
        Pattern p = Pattern.compile("[1-9][0-9]?");
        Matcher m = p.matcher(str);
        boolean flag = m.matches();
        if(!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), ErrorTypeEnum.IS_GRADE_CODE.getMessage());
        }
        return instance;
    }


}
