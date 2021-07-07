package com.example.datastructures.stack;

/**
 * @description:计算器
 * @author:dingsong.gao
 * @createTime:2021/7/6 16:32
 * @version:1.0
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "3+2*6-2";
        // 创建两个栈，一个是数栈  一个是号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);

        // 定义需要的相关变量
        int index =0;
        int num1 =0;
        int num2 =0;
        int oper =0;
        int res =0;

        char ch = ' '; // 将每次扫描得到的char保存到ch
        // 开始while循环的扫描expression
        while (true){
            // 依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            // 判断ch是什么  然后做出相应的处理
            if (operStack.isOper(ch)){ // 如果是运算符
                if (!operStack.isEmpty()){
                    // 符号栈不为空
                    // 如果符号栈不为空，就进行比较，如果当钱的操作符的有优先级小于或者等于符号栈中的操作符，就需要从数栈中pop出两个数据
                    // 在从符号栈pop中一个符号，进行运算，将得到的结果入数栈  然后将当前的操作符入符号栈

                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        // 把运算的结果入数栈
                        res = numStack.cal(num1,num2,oper);
                        numStack.push(res);
                        // 然后将当前的操作符入符号栈
                        operStack.push(ch);
                    }else {
                        // 如果当前操作符的优先级大于栈中 的操作符，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    // 如果为空，直接入符号栈
                    operStack.push(ch);
                }
            }else {
                // 如果是数  则直接入数栈
                numStack.push(ch -48);
            }
            // 让index+1 并判断是否扫描到expression最后
            index++;
            if (index >= expression.length()){
                break;
            }

        }


        // 当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号 并运行
        while (true){
            // 如果符号栈为空，则计算到最后的结果 数栈中只有一个数字 那就是最后的结果
            if (operStack.isEmpty()){
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            // 把运算的结果入数栈
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);

        }
        int pop = numStack.pop();
        System.out.printf("表达式%s = %d",expression,pop);

    }
}

// 定义一个ArrayStack  表示栈
class ArrayStack2{

    //栈的大小
    private int maxSize;

    private int[] stack;// 数组，数组模拟栈，数据就放在该数组

    private int top = -1;// top表示栈顶，初始化为-1

    // 构造器
    public ArrayStack2 (int maxSize){
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    // 增加一个方法，可以返回当前栈顶的值，但是不是真正的pop
    public int peek(){
        return stack[top];
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


    // 返回运算符的优先级，优先级使用数字表示，数字越大，优先级越高
    // char类型和int类型可以直接比较，因为char底层就是数字
    public int priority(int oper){
        if (oper == '*' || oper == '/'){
            return 1;
        }else if (oper == '+' || oper == '-'){
            return 0;
        }else {
            return -1;// 假定目前的表示式中石油+-*/
        }

    }


    // 判断是不是一个运算符
    public boolean isOper(char val){
        return val == '+' || val == '-' || val == '*' || val == '/' ;
    }

    // 计算方法
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}