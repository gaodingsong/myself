package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

//        int[] arr = {3, 9, -1, 10, 20 };

//        System.out.println("排序前的数组:"+ Arrays.toString(arr));
        // 冒泡排序的 时间复杂度  o(n^2)  因为是双层循环  测试8w数据的排序
        int size = 80000;
        int[] arr = new int[size];


        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*80000);

        }
        System.out.println(Arrays.toString(arr));

        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        bubbleSort(arr);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);

//        System.out.println("排序后的数组:"+ Arrays.toString(arr));

    }
    // 将冒泡排序封装成一个方法
    public static void bubbleSort(int[] arr){

        // 冒泡排序的 时间复杂度  o(n^2)  因为是双层循环
        int temp = 0;// 临时变量

        boolean flag = false;// 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length -1 - i; j++) {
                // 如果前面比后面的大，则交换
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }

//            if (flag == false ){  等价于下面的   if (!flag){
            if (!flag){
                // 说明在一趟排序中一次交换都没有发生过
                break;
            }else {
                flag = false;// 重置flag  进行下次排序
            }
        }
    }
}
