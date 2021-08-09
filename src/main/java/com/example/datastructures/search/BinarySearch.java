package com.example.datastructures.search;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,8, 10, 89, 1000, 1234};
        int resIndex = binarySearch(arr,0,arr.length,1234);
        System.out.println("resIndex:"+resIndex);


    }

    /**
     *
     * @param arr 原始数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal 要查找的值  如果找不到就返回-1
     * @return
     */
    public static int binarySearch(int[] arr ,int left,int right,int findVal){
        // 当left大于right的时候 说明递归整个数组，但是没有找到
        if (left > right){
            return -1;
        }
        int mid = (left+ right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            // 向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            // 向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }
}
