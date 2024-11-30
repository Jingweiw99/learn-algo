package com.wjw;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 5, 4};
        System.out.println(Arrays.toString(arr));
//        bubbleSort(arr);
//        selectedSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // 选择排序
    public static void selectedSort(int[] arr) {
        // 找n-1轮每次的最小值和遍历第一个进行交换
        // for i = 0 ~ n - 2
        // for j = i + 1 ~ n -1
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    /*
     插入排序
     */
    public static void insertionSort(int[] arr){
        int n = arr.length;
        int sortedIndex = 0;
        // 这里类似于滑动窗口，每次加入一个 其中[0, sortedIndex)是有序的
        while(sortedIndex < n) {
            // 需要将sortedIndex上面的与前面进行逐个对比
            // for i = sortedIndex ~ 1
            for(int i = sortedIndex; i > 0; i--) {
                if(arr[i] < arr[i -1]) {
                    int temp = arr[i];
                    arr[i] = arr[i-1];
                    arr[i-1] = temp;
                } else {
                    // 比最大的还相等或者大不需要排序
                    break;
                }
            }
            sortedIndex++;
        }
    }
}
