package com.example.datastructures.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        // 先定义一个逆波兰表达式
        // （3+4）x 5 -6
//        String suffixExpression = "30 4 + 5 * 6 - ";
        String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
        // 思路
        // 1. 先将3 4 + 5 x 6 - 放到ArrayList中
        // 2.将ArrayList传递给一个方法。遍历ArrayList配合栈完成计算
        List<String> list = getListString(suffixExpression);
        System.out.println(list);
        int calculate = calculate(list);
        System.out.println("最后的运算结果="+ calculate);


    }

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
