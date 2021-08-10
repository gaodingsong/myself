package com.example.datastructures.search;

import java.util.Arrays;

/**
 * 插值查找算法
 */
public class InsertValueSearch {
    public static void main(String[] args) {
//        int[] arr = new int[100];
//        for (int i = 0; i < 100; i++) {
//            arr[i] =i+1;
//        }
        int[] arr ={1,8, 10, 89, 1000, 1000,1000,1000,1000,1234};

//        int[] arr ={1,2,4,5,6,8,9,90};
        int index = insertValueSearch(arr, 0, arr.length - 1, 12);

        System.out.println(index);

    }

    /**
     * 插值查找算法
     * @param arr 原始数组
     * @param left 左边索引
     * @param right 右边索引
     * @param findVal 要查找的值  如果找到就返回对应的下标 否则就返回-1
     * @return
     */
    public static int insertValueSearch(int[] arr,int left ,int right,int findVal){

        System.out.println("查找次数~~");
        // 因为数组是有序的，要是小于最小的或者大于最大的 就肯定找不到
        //  findVal < arr[0]  || findVal >arr[arr.length-1] 这两个必须要  否则mid可能越界
        if (left > right || findVal < arr[0]  || findVal >arr[arr.length-1]  ){
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVal= arr[mid];
        if (findVal > midVal ){
            // 向右递归
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            // 向左递归
            return insertValueSearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
