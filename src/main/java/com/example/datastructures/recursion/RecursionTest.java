package com.example.datastructures.recursion;

public class RecursionTest {
    public static void main(String[] args) {
//        test(3);
        int factorial = factorial(4);
        System.out.println(factorial);

    }


    // 打印
    public static void test(int n){
        if (n>2){
            test(n-1);
        }
        System.out.println("n="+n);
    }

    // 階乘
    public static int factorial(int n){
        if (n==1){
            return 1;
        }else {
            return factorial(n-1)*n;
        }

    }
}
