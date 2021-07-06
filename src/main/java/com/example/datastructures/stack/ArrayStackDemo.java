package com.example.datastructures.stack;


import java.util.Scanner;

/**
 * @description:用数组模拟栈
 * @author:dingsong.gao
 * @createTime:2021/7/4 19:14
 * @version:1.0
 */
public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(4);
        String key ="";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop){
            System.out.println("show :表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push:表示添加数据到栈（入栈）");
            System.out.println("pop:表示从 栈中去取数据  （出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                   try {
                       int pop = stack.pop();
                       System.out.println(pop);
                   }catch (Exception e){
                       System.out.println(e.getMessage());
                   }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


// 定义一个ArrayStack  表示栈
class ArrayStack{

    //栈的大小
    private int maxSize;

    private int[] stack;// 数组，数组模拟栈，数据就放在该数组

    private int top = -1;// top表示栈顶，初始化为-1

    // 构造器
    public ArrayStack (int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 栈满
    public boolean isFull(){
        return top ==  maxSize-1;
    }
    // 栈空
    public boolean isEmpty(){
        return top == -1;
    }
    // 入栈
    public void push(int value){
        if (isFull()){
            System.out.println("栈满~~");
            return;
        }
        top++;
        stack[top] = value;
    }
    // 出栈
    public int pop(){
        // 判断是否为空
        if (isEmpty()){
            // 栈空  抛出异常
            throw new RuntimeException("栈空 没有数据~~");
        }
        int value = stack[top];
        top--;
        return value;

    }

    // 遍历栈  从栈顶 开始遍历
    public void list(){
        if (isEmpty()){
            System.out.println("栈空 没有数据~~");
            return;
        }
        // 从栈顶开始遍历
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }

}