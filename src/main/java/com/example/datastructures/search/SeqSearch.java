package com.example.datastructures.search;

/**
 * 顺序(线性)查找
 */
public class SeqSearch {
    public static void main(String[] args) {

        int[] arr = {1,8, 10, 89, 1000, 1234};
        int index = seqSearch(arr,1000);
        if (index ==-1){
            System.out.println("未找到哦啊");

        }else {
            System.out.println("找到了 :"+index);
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
