package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.CommonUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        int[] arr = CommonUtil.randomArr(80000);

        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
//        shellSort2(arr);
        SortUtils.shellSort(arr);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
//        System.out.println(Arrays.toString(arr));

    }


    /**
     * 希尔排序 交换法
     * @param arr
     */
    public static void shellSort(int[] arr){
        int temp = 0;
        int count = 0;
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            // 因为是第一轮，10个数据  所以分成了五组
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中的每个元素，  共五组，每组两个元素，步长gap
                for (int j = i-gap; j >= 0 ; j-= gap) {
                    // 如果当前元素大于加上步长之后的元素，说明交换
                    if ( arr[j] > arr[j+gap] ){
                        temp = arr[j];
                        arr[j] = arr[j+ gap];
                        arr[j+ gap] = temp;
                    }

                }

            }
//            System.out.println("希尔排序第"+(++count)+"轮 = "+ Arrays.toString(arr));
        }
        
        
//
//
//        // 因为是第一轮，10个数据  所以分成了五组
//        for (int i = 5; i < arr.length; i++) {
//            // 遍历各组中的每个元素，  共五组，每组两个元素，步长5
//            for (int j = i-5; j >= 0 ; j-= 5) {
//                // 如果当前元素大于加上步长之后的元素，说明交换
//                if ( arr[j] > arr[j+5] ){
//                    temp = arr[j];
//                    arr[j] = arr[j+ 5];
//                    arr[j+ 5] = temp;
//                }
//
//            }
//
//        }
//        System.out.println("第一轮排序后的顺序");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 因为是第二轮，10个数据  所以分成了5/2=2组
//        for (int i = 2; i < arr.length; i++) {
//            // 遍历各组中的每个元素，  共五组，每组两个元素，步长5
//            for (int j = i-2; j >= 0 ; j-= 2) {
//                // 如果当前元素大于加上步长之后的元素，说明交换
//                if ( arr[j] > arr[j+2] ){
//                    temp = arr[j];
//                    arr[j] = arr[j+ 2];
//                    arr[j+ 2] = temp;
//                }
//
//            }
//
//        }
//        System.out.println("第二轮排序后的顺序");
//        System.out.println(Arrays.toString(arr));
//
//
//        // 因为是第三轮，10个数据  所以分成了5/2/2=1组
//        for (int i = 1; i < arr.length; i++) {
//            // 遍历各组中的每个元素，  共五组，每组两个元素，步长5
//            for (int j = i-1; j >= 0 ; j-= 1) {
//                // 如果当前元素大于加上步长之后的元素，说明交换
//                if ( arr[j] > arr[j+1] ){
//                    temp = arr[j];
//                    arr[j] = arr[j+ 1];
//                    arr[j+ 1] = temp;
//                }
//
//            }
//
//        }
//        System.out.println("第三轮排序后的顺序");
//        System.out.println(Arrays.toString(arr));

    }


    /**
     * 希尔排序 移位法
     * @param arr
     */
    public static void shellSort2(int[] arr){
        // 增量gap  并逐渐缩小增量
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            // 从第gap个元素，逐个对其所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp< arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j-= gap;
                    }
                    // 当退出循环 说明找到位置
                    arr[j] = temp;
                }

                
            }

        }
    }
}
