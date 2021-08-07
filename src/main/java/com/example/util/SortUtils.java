package com.example.util;

/**
 * 排序工具类
 */
public class SortUtils {

    // 冒泡排序   会随着数据的增加而耗时越来越长
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

    // 选择排序  从小到大
    public static void selectSortFromSmallToBig (int[] arr){

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

    }

    // 选择排序  从小到大
    public static void selectSortFromBigToSmall(int[] arr){

        // 选择排序的 时间复杂度  o(n^2)  因为是双层循环
        for (int i = 0; i < arr.length-1; i++) {
            // 第一轮  找到第一轮的最小值
            // 先假定arr数组的第一个值是最小值
            int minIndex = i;// 最小值的索引
            int min = arr[i];// 最小值

            // 因为假定第一个值是最小值，所以，要和下一个数进行比较，所以j要0+1
            for (int j = i +1; j < arr.length; j++) {
                if ( min < arr[j]){
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

    }

}
