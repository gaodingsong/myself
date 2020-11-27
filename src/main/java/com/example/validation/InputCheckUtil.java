package com.example.validation;


import com.example.constant.ErrorConstant;
import com.example.enumeration.ErrorTypeEnum;
import com.example.expection.MyRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author majiawei
 * @classname InputCheckUtil
 * @desc
 * @date create in 2020/7/29 13:38
 */
public class InputCheckUtil {

    private InputCheckUtil() {
    }

    private static final InputCheckUtil instance = new InputCheckUtil();

    public static InputCheckUtil checker() {
        return instance;
    }

    public InputCheckUtil checkNull(Object object, String fieldName) {
        if (object == null) {
            throw new MyRuntimeException(ErrorTypeEnum.PARAM_ERROR.getCode(), String.format(ErrorConstant.PARAM_ERROR, fieldName));
        }
        return instance;
    }

    public InputCheckUtil checkEmpty(String value, String fieldName) {
        if (value == null || value.length() == 0) {
            throw new MyRuntimeException(ErrorTypeEnum.PARAM_ERROR.getCode(), String.format(ErrorConstant.PARAM_ERROR, fieldName));
        }
        return instance;
    }

    /**
     * 校验手机号是否全是数字
     * @param str
     * @return
     */
    public InputCheckUtil isNumeric(String str, ErrorTypeEnum errorTypeEnum) {
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
     * 校验名称长度是否等于13
     * @param str
     * @return
     */
    public InputCheckUtil validatePhoneLength(String str, ErrorTypeEnum errorTypeEnum) {

        boolean flag = str.length() == 11;
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), ErrorTypeEnum.VALIDATE_NAME_LENGTH.getMessage());
        }
        return instance;
    }




    /**
     * 校验名称长度是否在1-30之间
     * @param str
     * @return
     */
    public InputCheckUtil validateNameLength(String str, ErrorTypeEnum errorTypeEnum) {

        boolean flag = str.length() <= 30;
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验时间是否大于当前时间
     * @param date
     * @return
     */
    public InputCheckUtil compareDate(Date date, ErrorTypeEnum errorTypeEnum) {

        boolean flag = date.getTime() - System.currentTimeMillis() > 0;
        if (flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验余额长度是否大于10位
     * */
    public InputCheckUtil validateBalance(String str, ErrorTypeEnum errorTypeEnum) {

        boolean flag = str.length() > 0 && str.length() <= 10;
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验积分是否为负数
     * */
    public InputCheckUtil isInteger(String str, ErrorTypeEnum errorTypeEnum) {


        if (Integer.valueOf(str)<0){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验积分长度是否超过10位
     * */
    public InputCheckUtil validateLengthInteger(String str, ErrorTypeEnum errorTypeEnum) {

        boolean flag = str.length() <10;
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验空字符串
     * @param object
     * @param
     * @return
     */
    public InputCheckUtil checkNullStr(Object object, ErrorTypeEnum errorTypeEnum) {

        if (Objects.equals(null,object)) {
            throw new MyRuntimeException(ErrorTypeEnum.VALIDATE_ACCOUNT.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 校验是否为空
     * @param str
     * @param errorTypeEnum
     * @return
     */
    public InputCheckUtil isBlank(String str, ErrorTypeEnum errorTypeEnum) {

        if (StringUtils.isBlank(str) ) {
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 是否重复
     * @param flag
     * @param errorTypeEnum
     * @return
     */
    public InputCheckUtil isExist(boolean flag, ErrorTypeEnum errorTypeEnum) {
        if (flag) {
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    public InputCheckUtil checkBlank(String value, String fieldName) {
        if (StringUtils.isBlank(value)) {
            throw new MyRuntimeException(ErrorTypeEnum.PARAM_ERROR.getCode(), String.format(ErrorConstant.PARAM_NULL, fieldName));
        }
        return instance;
    }



    /**
     * 是否重复
     * @param str
     * @param errorTypeEnum
     * @return
     */
    public InputCheckUtil verifyLength(String str, ErrorTypeEnum errorTypeEnum) {
        if (str.length()>25) {
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }



    /**
     * 判断等级名称是否是特殊符号
     * */
    public InputCheckUtil validateGradeName(String str, ErrorTypeEnum errorTypeEnum){
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
    public InputCheckUtil isGradeCode(String str, ErrorTypeEnum errorTypeEnum){
        Pattern p = Pattern.compile("[1-9][0-9]?");
        Matcher m = p.matcher(str);
        boolean flag = m.matches();
        if(!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), ErrorTypeEnum.IS_GRADE_CODE.getMessage());
        }
        return instance;
    }

    /**
     * 判断成长值是否是大于0并且长度在7以内的正整数
     * */
    public InputCheckUtil isGradeUp(Long str, ErrorTypeEnum errorTypeEnum){
        String str1=String.valueOf(str);
        if(!(str1.length()<8)&&(Integer.parseInt(str1)>0)) {
            throw new MyRuntimeException(errorTypeEnum.getCode(), ErrorTypeEnum.IS_GRADE_UP_HP.getMessage());
        }
        return instance;
    }

    /**
     * 判断等级名称长度
     * */
    public InputCheckUtil validateName(String str, ErrorTypeEnum errorTypeEnum) {

        boolean flag =str.length()>=2 && str.length()<=25;
        if (!flag){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

    /**
     * 判断会员协议长度
     * */
    public InputCheckUtil validateProtocolContent(String str, ErrorTypeEnum errorTypeEnum){
        if(str.length()>500){
            throw new MyRuntimeException(errorTypeEnum.getCode(), errorTypeEnum.getMessage());
        }
        return instance;
    }

}
