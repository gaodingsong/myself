package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.CommonUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {

//        int[] arr = {101, 34, 119, 1 ,-1,89 };
        int[] arr = CommonUtil.randomArr(8);
        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        insertSort(arr);
        SortUtils.insertSortFromBigToSmall(arr);
        SortUtils.insertSortFromSmallToBig(arr);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
        System.out.println(Arrays.toString(arr));
    }




    public static void insertSort(int[] arr){

        int insertVal = 0;
        int insertIndex = 0; // 即arr[1]前面这个数的下标

        for (int i = 1; i < arr.length; i++) {

            // {101, 34, 119, 1  }
            // 1。定义待插入的数据
            insertVal = arr[i];
            insertIndex = i-1; // 即arr[1]前面这个数的下标


            // 给insertValue找到插入的位置
            // 说明：
            // 1,insertIndex >= 0保证给insertVal找插入位置，不越界
            // 2,insertVal<arr[insertIndex] 说明还没有找到待插入的位置
            // 3,就需要将insertIndex--  后移
            while (insertIndex >= 0 && insertVal  < arr[insertIndex]){
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while的时候  说明找到了插入位置，insertIndex+1
            // 这里判断一下是否需要赋值
            if (insertIndex +1 != i){
                arr[insertIndex +1] = insertVal;
            }

        }





        /*
        // 第二轮
        insertVal = arr[2];
        insertIndex = 2-1; // 即arr[1]前面这个数的下标
        while (insertIndex >= 0 && insertVal<arr[insertIndex]){
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while的时候  说明找到了插入位置，insertIndex+1
        arr[insertIndex +1] = insertVal;

        System.out.println("第二轮插入");
        System.out.println(Arrays.toString(arr));
        // 第三轮
        insertVal = arr[3];
        insertIndex = 3-1; // 即arr[1]前面这个数的下标
        while (insertIndex >= 0 && insertVal<arr[insertIndex]){
            arr[insertIndex +1] = arr[insertIndex];
            insertIndex--;
        }
        // 当退出while的时候  说明找到了插入位置，insertIndex+1
        arr[insertIndex +1] = insertVal;

        System.out.println("第三轮插入");
        System.out.println(Arrays.toString(arr));


         */

    }

}
