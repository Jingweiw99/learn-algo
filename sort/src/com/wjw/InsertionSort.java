package com.wjw;

/*
插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 6, 1, 3, 4, 6};
        printArr(arr);
        insertSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
    插入排序思路：从 i = 1 ~ n-1 枚举，然后前面的i-1就是排序好的区间
    枚举每次如果碰到当前的i位置上的值小于前面的位置的值，直接交换 这个过程也需要枚举需要j = i-1 ~ 0
     */
    private static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            while (j >= 0) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr, j, j + 1);
                }
                j--;
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
