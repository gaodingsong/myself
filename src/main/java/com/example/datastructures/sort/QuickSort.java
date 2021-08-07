package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.CommonUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
//        int[] arr ={-9,78,0,23,-567,70,2,-2,200,-90,287};
        int[] arr = CommonUtil.randomArr(8000000);



        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        quickSort(arr,0,arr.length-1);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
//        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort( int[] arr,int left ,int right){
        int l = left;
        int r = right;

        // pivot 中轴值  也就是数组最中间的那个
        int pivot = arr[(left+ right)/2];
        int temp = 0;// 临时变量，作为交换时使用

        // while的目的是让比pivot小的值放在左边，比pivot大的放在右边
        while ( l < r){
            // 在pivot左边一直找，找到大于等于pivot的值得时候才退出
            while (arr[l] < pivot){
                l+=1;
            }
            // 在pivot右边一直找，找到小于等于pivot的值得时候才退出
            while (arr[r]> pivot){
                r -= 1;
            }
            // 如果 if ( l > r){  说明pivot左右两边的值已经按照左边全是小于pivot的值，右边都是大于pivot的值
            if ( l >= r){
                break;
            }
            // 交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] =temp;

            // 如果做完交换后，发现arr[l] == pivot  就让r-- 前移一位
            if(arr[l] == pivot){
                r -= 1;
            }
            // 如果做完交换后，发现arr[rl] == pivot  就让l++ 前移一位
            if(arr[r] == pivot){
                l += 1;
            }
        }
        // 如果l==r  必须让l++  r-- 否则会出现栈溢出
        if (l==r){
            l+=1;
            r-=1;
        }

        // 向左递归
        if (left < r){
            quickSort(arr, left, r);
        }
        // 向右递归
        if (right > l){
            quickSort(arr, l, right);
        }


    }
}
