package com.example.util;

import java.util.ArrayList;

/**
 * 查找算法 工具类
 */
public class SearchUtils {


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




    /**
     *二分查找法  只查一个
     * @param arr 原始数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal 要查找的值  如果找不到就返回-1
     * @return
     */
    public static int binarySearchOne(int[] arr ,int left,int right,int findVal){
        // 当left大于right的时候 说明递归整个数组，但是没有找到
        if (left > right){
            return -1;
        }
        int mid = (left+ right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            // 向右递归
            return binarySearchOne(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            // 向左递归
            return binarySearchOne(arr,left,mid-1,findVal);
        }else {
            return mid;
        }

    }

    /**
     * 思考
     *{1,8, 10, 89, 1000, 1000，1234} 当一个有序数组中，有多个相同的数值时，如何将所有的数值都查找到，比如这里的 1000.
     * 1，在找到mid 索引值 不要马上返回
     * 2.向mid索引值左边扫描 将所有满足1000 的元素的下标加入到ArrayList中
     * 3.向mid索引值右边扫描 将所有满足1000 的元素的下标加入到ArrayList中
     * 4.将ArrayList返回
     */
    /**
     *二分查找法  查询所有
     * @param arr 原始数组
     * @param left  左边索引
     * @param right  右边索引
     * @param findVal 要查找的值  如果找不到就返回-1
     * @return
     */
    public static ArrayList<Integer> binarySearchAll(int[] arr , int left, int right, int findVal){
        // 当left大于right的时候 说明递归整个数组，但是没有找到
        if (left > right){
            return new ArrayList<Integer>();
        }
        int mid = (left+ right)/2;
        int midVal = arr[mid];
        if (findVal > midVal){
            // 向右递归
            return binarySearchAll(arr,mid+1,right,findVal);
        }else if (findVal < midVal){
            // 向左递归
            return binarySearchAll(arr,left,mid-1,findVal);
        }else {
//            return mid;
            /**
             *      * 1，在找到mid 索引值 不要马上返回
             *      * 2.向mid索引值左边扫描 将所有满足1000 的元素的下标加入到ArrayList中
             *      * 3.向mid索引值右边扫描 将所有满足1000 的元素的下标加入到ArrayList中
             *      * 4.将ArrayList返回
             */

            ArrayList<Integer> resIndexList = new ArrayList<Integer>();
            // 向mid索引值左边扫描 将所有满足1000 的元素的下标加入到ArrayList中
            int temp = mid - 1;
            while (true){
                if (temp < 0 || arr[temp] != findVal){
                    break;
                }
                // 否则 将temp加入到resIndexList
                resIndexList.add(temp);
                temp -= 1; // temp左移
            }

            resIndexList.add(mid);
            // 3.向mid索引值右边扫描 将所有满足1000 的元素的下标加入到ArrayList中
            temp = mid + 1;
            while (true){
                if (temp > arr.length -1 || arr[temp] != findVal){
                    break;
                }
                // 否则 将temp加入到resIndexList
                resIndexList.add(temp);
                temp += 1; // temp左移
            }
            return resIndexList;

        }

    }


    public static int seqSearch(int[] arr,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value){
                return i;
            }

        }
        return -1;

    }
}
