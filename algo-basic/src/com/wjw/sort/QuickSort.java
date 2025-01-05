package com.wjw.sort;

import java.util.Arrays;

/*
快速排序
 */
public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    // 递归实现快速排序
    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    // 分区方法 小于等于的数放到基准元素的左边，然后将基准元素放到正确的位置，最后返回基准元素的位置
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right]; // 选择最后一个元素作为基准
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 1, 2};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
