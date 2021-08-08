package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.CommonUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 归并排序  先分后合
 */
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2};
//        int[] temp = new int[arr.length];
//        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println(Arrays.toString(arr));



        int[] arr = CommonUtil.randomArr(10000000);
        int[] temp = new int[arr.length];
        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
//        mergeSort(arr,0,arr.length-1,temp);
        SortUtils.mergeSort(arr,0,arr.length-1,temp);

        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
//        System.out.println(Arrays.toString(arr));

    }


    /**
     * 归并排序   分+ 合
     * @param arr
     * @param left
     * @param right
     * @param temp
     */
    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left + right)/2;// 中间索引
            // 向左递归分解
            mergeSort(arr,left,mid,temp);
            // 向又递归分解
            mergeSort(arr,mid+1,right,temp);
            // 合并
            merge(arr,left,mid,right,temp);
        }

    }

    /**
     * 归并排序    合的方法
     * @param arr 要排序的原始数组
     * @param left 左边有序序列的原始索引
     * @param mid  中间索引
     * @param right  右边索引
     * @param temp  做中转的数组
     */
    public static void merge(int[] arr,int left,int mid,int right,int[] temp){
        int i = left; // 初始化i  左边有序序列的原始索引
        int j = mid +1;// 初始化j  右边有序序列的原始索引
        int t = 0;// 指向temp数组的当前索引

        //1,先把左右两边有序的数据按照规则填充到temp数组中，直到左右两边的有序序列，有一边 处理完为止
        while (i <= mid && j <=right ){
            // 如果左边有序列表的当前元素小于等于右边列表的当前元素
            // 即 将左边的当前元素填充到temp中
            // 然后t++   i++
            if (arr[i] <= arr[j]){
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                // 反之 如果右边有序列表的当前元素小于等于左边列表的当前元素 将右边的当前元素填充到temp中
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        //2,把有剩余的一边的数据依次全部填充到temp
        while (i <= mid ){
            // 说明左边的有序序列中还有元素，就全部填充到temp
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right ){
            // 说明右边边的有序序列中还有元素，就全部填充到temp
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }

        //3,将temp数组中的数据copy到arr  注意 并不是每次都把所有的拷贝
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right){
            arr[tempLeft] = temp[t];
            t+=1;
            tempLeft +=1;
        }


    }
}
