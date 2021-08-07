package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101, 34, 119, 1,-10,-90,82,67};
//        System.out.println("排序前:"+Arrays.toString(arr));

        int size = 80000;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*80000);
        }
        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        selectSort(arr);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
//        SortUtils.selectSortFromSmallToBig(arr);
//        SortUtils.selectSortFromBigToSmall(arr);
//        System.out.println("排序后:"+Arrays.toString(arr));
    }


    public static void selectSort(int[] arr){

        // 选择排序的 时间复杂度  o(n^2)  因为是双层循环
        for (int i = 0; i < arr.length-1; i++) {
            // 第一轮  找到第一轮的最小值
            // 先假定arr数组的第一个值是最小值
            int minIndex = i;// 最小值的索引
            int min = arr[i];// 最小值
            // 因为假定第一个值是最小值，所以，要和下一个数进行比较，所以j要0+1
            for (int j = i +1; j < arr.length; j++) {
                if ( min > arr[j]){
                    // 说min不是最小值
                    min = arr[j];// 重置min最小值
                    minIndex = j;// 重置最小是索引 minIndex
                }
            }
            // 将最小值  放在arr【0】  即交换
            if (minIndex!= i){
                arr[minIndex] = arr[i];  // 最大值和最小值交换位置
                arr[i] = min;// 最小值从新赋值
            }
        }

        /*

        // 第二轮  找到第二轮的最小值
        // 先假定arr数组的第一个值是最小值
         minIndex = 1;// 最小值的索引
         min = arr[1];// 最小值

        // 因为假定第二个值是最小值，所以，要和下一个数进行比较，所以j要1+1
        for (int j = 1 +1; j < arr.length; j++) {
            if ( min > arr[j]){
                // 说min不是最小值
                min = arr[j];// 重置min最小值
                minIndex = j;// 重置最小是索引 minIndex
            }

        }

        // 将最小值  放在arr【0】  即交换

        if (minIndex!= 1){
            arr[minIndex] = arr[1];  // 最大值和最小值交换位置
            arr[1] = min;// 最小值从新赋值
        }

        System.out.println("第二轮交换的结构：");
        System.out.println(Arrays.toString(arr));


        // 第三轮  找到第三轮的最小值
        // 先假定arr数组的第一个值是最小值
        minIndex = 2;// 最小值的索引
        min = arr[2];// 最小值

        // 因为假定第三个值是最小值，所以，要和下一个数进行比较，所以j要1+1
        for (int j = 2 +1; j < arr.length; j++) {
            if ( min > arr[j]){
                // 说min不是最小值
                min = arr[j];// 重置min最小值
                minIndex = j;// 重置最小是索引 minIndex
            }

        }

        // 将最小值  放在arr【0】  即交换

        if (minIndex!= 2){
            arr[minIndex] = arr[2];  // 最大值和最小值交  换位置
            arr[2] = min;// 最小值从新赋值
        }

        System.out.println("第三二轮交换的结构：");
        System.out.println(Arrays.toString(arr));*/


    }
}
