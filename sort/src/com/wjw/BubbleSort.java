package com.wjw;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 6, 1, 3, 4, 6};
        printArr(arr);
        bubbleSort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*
    冒泡排序：i = n - 1 ~ 0 排序
    然后每次 j = 0 - end - 1  与后面一个交换
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
