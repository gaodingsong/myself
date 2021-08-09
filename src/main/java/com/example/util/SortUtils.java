package com.example.util;

/**
 * 排序工具类
 */
public class SortUtils {


    /**
     *  基数排序
     * @param arr
     */
    public static void radixSort(int[] arr) {

        // 1.得到数组中最大的数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 得到最大数是几位数
        int maxLength = (max + "").length();

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

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            // 针对每个元素的对应的位锦进行处理  第一次是个位  第二次是十位 第三次是百位
            for (int j = 0; j < arr.length; j++) {
                // 取出每个元素的个位的值
                int digitOfElement = arr[j] / n % 10;
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
                if (bucketElementCounts[k] != 0) {
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

    // 冒泡排序   会随着数据的增加而耗时越来越长
    public static void bubbleSort(int[] arr){

        // 冒泡排序的 时间复杂度  o(n^2)  因为是双层循环
        int temp = 0;// 临时变量
        boolean flag = false;// 标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length -1 - i; j++) {
                // 如果前面比后面的大，则交换
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
//            if (flag == false ){  等价于下面的   if (!flag){
            if (!flag){
                // 说明在一趟排序中一次交换都没有发生过
                break;
            }else {
                flag = false;// 重置flag  进行下次排序
            }
        }
    }

    // 选择排序  从小到大
    public static void selectSortFromSmallToBig (int[] arr){

        // 选择排序的 时间复杂度  o(n^2)  因为是双层循环
        for (int i = 0; i < arr.length-1; i++) {
            // 第一轮  找到第一轮的最小值
            // 先假定arr数组的第一个值是最小值
            int minIndex = i;// 最小值的索引
            int min = arr[i];// 最小值

            // 因为假定第一个值是最小值，所以，要和下一个数进行比较，所以j要0+1
            for (int j = i +1; j < arr.length; j++) {
                if ( min > arr[j]){
                    // 说min不是最小值
                    min = arr[j];// 重置min最小值
                    minIndex = j;// 重置最小是索引 minIndex
                }
            }
            // 将最小值  放在arr【0】  即交换
            if (minIndex!= i){
                arr[minIndex] = arr[i];  // 最大值和最小值交换位置
                arr[i] = min;// 最小值从新赋值
            }
        }

    }

    // 选择排序  从小到大
    public static void selectSortFromBigToSmall(int[] arr){

        // 选择排序的 时间复杂度  o(n^2)  因为是双层循环
        for (int i = 0; i < arr.length-1; i++) {
            // 第一轮  找到第一轮的最小值
            // 先假定arr数组的第一个值是最小值
            int minIndex = i;// 最小值的索引
            int min = arr[i];// 最小值

            // 因为假定第一个值是最小值，所以，要和下一个数进行比较，所以j要0+1
            for (int j = i +1; j < arr.length; j++) {
                if ( min < arr[j]){
                    // 说min不是最小值
                    min = arr[j];// 重置min最小值
                    minIndex = j;// 重置最小是索引 minIndex
                }
            }
            // 将最小值  放在arr【0】  即交换
            if (minIndex!= i){
                arr[minIndex] = arr[i];  // 最大值和最小值交换位置
                arr[i] = min;// 最小值从新赋值
            }
        }

    }

    /**
     * 插入排序，从小到大
     */
    public static void insertSortFromSmallToBig(int[] arr){
        int insertVal = 0;
        int insertIndex = 0; // 即arr[1]前面这个数的下标

        for (int i = 1; i < arr.length; i++) {

            // {101, 34, 119, 1  }
            // 1。定义待插入的数据
            insertVal = arr[i];
            insertIndex = i-1; // 即arr[1]前面这个数的下标


            // 给insertValue找到插入的位置
            // 说明：
            // 1,insertIndex >= 0保证给insertVal找插入位置，不越界
            // 2,insertVal<arr[insertIndex] 说明还没有找到待插入的位置
            // 3,就需要将insertIndex--  后移
            while (insertIndex >= 0 && insertVal  < arr[insertIndex]){
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while的时候  说明找到了插入位置，insertIndex+1
            // 这里判断一下是否需要赋值
            if (insertIndex +1 != i){
                arr[insertIndex +1] = insertVal;
            }

        }

    }


    /**
     * 插入排序  从大到小
     * @param arr
     */
    public static void insertSortFromBigToSmall(int[] arr){
        int insertVal = 0;
        int insertIndex = 0; // 即arr[1]前面这个数的下标

        for (int i = 1; i < arr.length; i++) {

            // {101, 34, 119, 1  }
            // 1。定义待插入的数据
             insertVal = arr[i];
             insertIndex = i-1; // 即arr[1]前面这个数的下标


            // 给insertValue找到插入的位置
            // 说明：
            // 1,insertIndex >= 0保证给insertVal找插入位置，不越界
            // 2,insertVal<arr[insertIndex] 说明还没有找到待插入的位置
            // 3,就需要将insertIndex--  后移
            while (insertIndex >= 0 && insertVal  > arr[insertIndex]){
                arr[insertIndex +1] = arr[insertIndex];
                insertIndex--;
            }
            // 当退出while的时候  说明找到了插入位置，insertIndex+1
            // 这里判断一下是否需要赋值
            if (insertIndex +1 != i){
                arr[insertIndex +1] = insertVal;
            }

        }

    }

    /**
     * 希尔排序移位法
     * @param arr
     */
    public static void shellSort(int[] arr){
        // 增量gap  并逐渐缩小增量
        for (int gap = arr.length/2; gap > 0 ; gap/=2) {
            // 从第gap个元素，逐个对其所在的组进行插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]){
                    while (j - gap >= 0 && temp< arr[j - gap]){
                        arr[j] = arr[j - gap];
                        j-= gap;
                    }
                    // 当退出循环 说明找到位置
                    arr[j] = temp;
                }


            }

        }
    }
}
