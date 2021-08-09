package com.example.datastructures.sort;

import cn.hutool.core.date.DateUtil;
import com.example.util.CommonUtil;
import com.example.util.SortUtils;

import java.util.Arrays;

/**
 * 基数排序
 */
public class RadixSort {
    public static void main(String[] args) {
//        int[] arr ={53, 3, 542, 748, 14, 214};
//        radixSort(arr);



        int[] arr = CommonUtil.randomArr(10000000);
        String now = DateUtil.now();
        System.out.println("排序前的时间："+now);
        radixSort(arr);


        String now2= DateUtil.now();
        System.out.println("排序后的时间："+now2);
//        System.out.println(Arrays.toString(arr));
    }


    /**
     *  基数排序
     * @param arr
     */
    public static void radixSort(int[] arr){

        // 1.得到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max = arr[i];
            }
        }

        // 得到最大数是几位数
        int maxLength = (max+"").length();

        // 定义一个二维数组  表示10个桶，每个桶是一个一维数组
        // 说明
        // 1.二维数组含十个一维数组
        // 2.为了防止放入数据的的时候，数据溢出，则每个一位数组（也就是桶的大小），大小定义为arr.length
        // 3.基数排序 是空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];

        // 为了记录每个桶中实际放了多少数据，我们定义一个一维数组来记录每个桶每次放入的数据的个数
        // 可以这样理解
        // 比如bucketElementCounts[0] 记录的就是bucket[0]桶中放入的数据的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++,n*=10) {

            // 针对每个元素的对应的位锦进行处理  第一次是个位  第二次是十位 第三次是百位
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的个位的值
                int digitOfElement = arr[j] /n %10;
                // 放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;

            }
            // 从桶中取出数据
            // 按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数据）
            int index = 0;
            //  遍历每个桶，并将每个桶的数据放入到原数组
            for (int k = 0; k < bucketElementCounts.length; k++) {
                // 如果桶中有数据，我们才放入原数组
                if (bucketElementCounts[k] != 0){
                    // 循环该桶 即第k个桶（即第k个一维数组），放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        // 取出元素，放入到arr
                        arr[index++] = bucket[k][l];

                    }
                }
                // 第i+1轮处理后 需要将每个bucketElementCounts[k] = 0
                bucketElementCounts[k] = 0;


            }
//            System.out.println("第"+(i+1)+"轮，对个位数处理的arr="+ Arrays.toString(arr));
        }
/*

        // 第一轮，针对每个元素的各位进行排序处理  把数组放入到桶中
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的个位的值
            int digitOfElement = arr[j]%10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;
            
        }
        // 从桶中取出数据
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数据）
         int index = 0;
        //  遍历每个桶，并将每个桶的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入原数组
            if (bucketElementCounts[k] != 0){
                // 循环该桶 即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素，放入到arr
                    arr[index++] = bucket[k][l];
                    
                }
            }
            // 第一轮处理后 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;


        }
        System.out.println("第一轮，对个位数处理的arr="+ Arrays.toString(arr));

        // ======================================================================

        // 第2轮，针对每个元素的各位进行排序处理  把数组放入到桶中
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的十位的值
            int digitOfElement = arr[j]/10%10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }
        // 从桶中取出数据
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数据）
         index = 0;
        //  遍历每个桶，并将每个桶的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入原数组
            if (bucketElementCounts[k] != 0){
                // 循环该桶 即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素，放入到arr
                    arr[index++] = bucket[k][l];
                }
            }
            // 第一轮处理后 需要将每个bucketElementCounts[k] = 0
            bucketElementCounts[k] = 0;
        }
        System.out.println("第2轮，对个位数处理的arr="+ Arrays.toString(arr));


        // ======================================================================

        // 第3轮，针对每个元素的各位进行排序处理  把数组放入到桶中
        for (int j = 0; j < arr.length; j++) {
            // 取出每个元素的百位的值
            int digitOfElement = arr[j]/100%10;
            // 放入到对应的桶中
            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
            bucketElementCounts[digitOfElement]++;

        }
        // 从桶中取出数据
        // 按照这个桶的顺序（一维数组的下标依次取出数据，放入到原来的数据）
        index = 0;
        //  遍历每个桶，并将每个桶的数据放入到原数组
        for (int k = 0; k < bucketElementCounts.length; k++) {
            // 如果桶中有数据，我们才放入原数组
            if (bucketElementCounts[k] != 0){
                // 循环该桶 即第k个桶（即第k个一维数组），放入
                for (int l = 0; l < bucketElementCounts[k]; l++) {
                    // 取出元素，放入到arr
                    arr[index++] = bucket[k][l];

                }
            }

        }
        System.out.println("第3轮，对个位数处理的arr="+ Arrays.toString(arr));
*/

    }
}
