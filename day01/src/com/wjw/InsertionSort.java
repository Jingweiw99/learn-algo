package com.wjw;

// 03 插入排序
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5, 6, 1, 3, 4, 6};
        printArr(arr);
        insertSort2(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    private static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            int newIndex = end;
            // 左边有数，并且比左边位置要小
            while (newIndex - 1 >= 0 && arr[newIndex] < arr[newIndex - 1]) {
                swap(arr, newIndex, newIndex - 1);
                newIndex--;
            }
        }
    }

    // 优化之后的插入排序  代码更短
    private static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int end = 1; end < n; end++) {
            // 只用pre来记录
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
