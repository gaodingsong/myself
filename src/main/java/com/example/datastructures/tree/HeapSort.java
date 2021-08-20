package com.example.datastructures.tree;

import cn.hutool.core.date.DateUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * @PROJECT_NAME: myself
 * @DESCRIPTION:
 * @USER: gaodingsong
 * @DATE: 2021/8/19 11:10
 */
public class HeapSort {
    public static void main(String[] args) {
        // 要求升序排列
//        int[] arr = {4,6,8,5,9,-2,-3,-343,898};


        int size = 8;
        int[] arr = new int[size];


        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*80000);

        }

        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        SortUtils.heapSort(arr);
        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);

        System.out.println(Arrays.toString(arr));

//        heapSort(arr);
    }

    public static void heapSort(int[] arr){
//        System.out.println("堆排序");

        int temp ;
//
//        adjustHeap(arr,1,arr.length);
//        System.out.println(Arrays.toString(arr));
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次调整："+Arrays.toString(arr));


        // 将一个无序序列调整一个大顶堆
        for (int i = arr.length/2-1; i >= 0 ; i--) {
            adjustHeap(arr,i,arr.length);
            
        }
        // 将顶堆元素与末尾元素交换，将最大元素  沉到数组末端

        for (int j = arr.length-1; j >0; j--) {
            // 交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);


        }


//        System.out.println(Arrays.toString(arr));


    }



    /**
     *  将一个数组（二叉树） 调整成一个大顶堆
     * @param arr  待调整的数组
     * @param i  表示非叶子节点在数组中的索引
     * @param length  表示对多少个元素进行继续调整，length在逐渐减少
     */
    public static void adjustHeap(int[] arr , int i, int length){


        int temp = arr[i];

        for (int k = i*2+1; k < length; k = i*2+1) {
            if (k+1< length && arr[k] < arr[k+1]){// 说明左子节点的值小于右子节点的值
                k++;
            }
            if(arr[k] > temp){// 如果子节点大于父节点
                arr[i] = arr[k];
                i=k;
            }else {
                break;
            }

        }

        // 当for循环结束后 我们已经将以i为父节点的树的最大值  放在了最顶（局部）
        arr[i] =temp;// 将temp值放到调整后的位置



    }
}
