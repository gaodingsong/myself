package com.example.datastructures.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找法
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr ={1,8, 10, 89, 1000, 1000,1000,1000,1000,1234};
//        int resIndex = binarySearchOne(arr,0,arr.length,1234);
//        System.out.println("resIndex:"+resIndex);

        List<Integer>  list = binarySearchAll(arr,0,arr.length,8);
        System.out.println(list);
    }

    /**
     *
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
}
