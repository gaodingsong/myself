package com.example.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 完成讲一个中缀表达式转成后缀表达式
        // 说明
        // 1. 1+((2+3)*4)-5 转成 1 2 3 + 4 * 5 -
        // 2.因为直接对str进行操作不方便，因此先将1+((2+3)*4)-5 == 》 中缀表达式对应的List
        // 即 1+((2+3)*4)-5 =》 ArrayList[1,+,(,(,2,+,3,),*,4,),-,5]
        // 3.将中缀表达式转的list转成后缀表达式

        String expression = "1+((2+3)*4)-5";

        List<String> ls = toInfixExpressionList(expression);
        System.out.println("中缀表达式List = "+ls);

        List<String> strings = parseSuffixExpressionList(ls);
        System.out.println("后缀表达式 = "+strings);// 结果：[1, 2, 3, +, 4, *, +, 5, -]


        System.out.printf("后缀表达式计算结果=%d",calculate(strings));

        // 先定义一个逆波兰表达式
        // （3+4）x 5 -6
//        String suffixExpression = "30 4 + 5 * 6 - ";
//        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
//        // 思路
//        // 1. 先将3 4 + 5 x 6 - 放到ArrayList中
//        // 2.将ArrayList传递给一个方法。遍历ArrayList配合栈完成计算
//        List<String> list = getListString(suffixExpression);
//        System.out.println(list);
//        int calculate = calculate(list);
//        System.out.println("最后的运算结果="+ calculate);


    }


    // 转后缀表达式
    public  static List<String> parseSuffixExpressionList(List<String> ls){
        // 先定义两个栈
        Stack<String> s1 = new Stack<>();// 符号栈
        // 说明：s2 这个栈因为在转换的过程中没有出栈操作，而且后续还需要逆序操作，所以定义成list

        List<String> s2 = new ArrayList<>();
        for (String item : ls) {
            // 如果是一个数 则加入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }else if (item.equals("(")){
                s1.push(item);
            }else if (item.equals(")")){
                // 如果数）则依次弹出s1栈顶的运算符，并压入s2 直到遇到（这个括号为止 此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();// 将s1 中的（ 弹出 消除小括号
            }else {
                // 当item的优先级小于等于s1 栈顶的运算符 将s1栈顶的运算符弹出并加入到s2中，再次转到4.1与s1 中新的 栈顶预运算符比较
                // 问题：我们缺少一个比较运算符高低的方法
                while (s1.size()!=0 && Operation.getValue(s1.peek()) >= Operation.getValue(item) ){
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈中
                s1.push(item);
            }
        }

        // 将s1 中剩余的运算符依次加入到s2
        while (s1.size() != 0){
            s2.add(s1.pop());
        }

        return s2;// 注意：因为放入的是list 因此按照顺序输出就是对应的后缀表达式对应的list

    }

    // 方法：将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s){
        // 定义一个list，存放中缀表达式对应的内容
        List<String> ls = new ArrayList<String>();
        int i = 0;// 这是一个指针，用于遍历中缀表达式字符串
        String str = "";// 多位数的拼接
        char c ;// 每遍历到一个字符，就放入到c
        do {
            // 如果c是一个非数字，我需要直接加入到ls
            if( (c=s.charAt(i)) < 48 ||( c=s.charAt(i)) > 57){
                ls.add(""+c);
                // i需要后移
                i++;
            }else {
                // 如果是一个数，就要考虑多位数
                str = "";
                while ( i<s.length() && ((c=s.charAt(i)) >= 48) && ( c=s.charAt(i)) <= 57){
                    str+=c;
                    i++;
                }
                ls.add(str);
            }

        }while (i<s.length());
        return ls;

    }




    // 将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        // 将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String s : split) {
            list.add(s);
        }
        return list ;
    }

    /**
     * 完成对逆波兰表达式的运算
     * 1.从左至右扫描，
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls){
        // 创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<>();
        // 遍历ls
        for (String item : ls) {

            // 这里使用正则表达式来取数
            if (item.matches("\\d+")){
                //匹配多位数
                // 入栈
                stack.push(item);
            }else {
                // 说明是运算符号
                // pop两个数 计算并入栈
               int num2= Integer.parseInt(stack.pop());
               int num1= Integer.parseInt(stack.pop());

               int res = 0;
               if (item.equals("+")){
                   res = num1+num2;
               }else if (item.equals("-")){
                   res = num1-num2;
               }
               else if (item.equals("*")){
                   res = num1*num2;
               }
               else if (item.equals("/")){
                   res = num1/num2;
               }else {
                   throw new RuntimeException("运算符有误");
               }
               // 把结果入栈
                stack.push(""+res);
            }
        }

        // 最后留在栈中的是最后的结果
        return Integer.parseInt(stack.pop());
    }
}
// 编写Operation类  返回符号的优先级
class Operation{
    private static int ADD =1;
    private static int SUB =1;
    private static int MUL =2;
    private static int DIV =2;

    // 写一个方法 返回对应数字的优先级
    public static int getValue(String operation){

        int result = 0;
        switch (operation){
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }

        return result;
    }







}
