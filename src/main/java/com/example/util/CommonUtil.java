package com.example.util;

public class CommonUtil {

    public static int[] randomArr(int size){
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = (int)(Math.random()*80000);

        }
        return arr;

    }
}
