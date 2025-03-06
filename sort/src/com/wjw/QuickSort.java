package com.wjw;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) return;
        int left = 0, right = arr.length - 1;
        sort(arr, left, right);
    }

    /*
    排序arr [left,right] 区间
     */
    private static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            sort(arr, left, pivot - 1);
            sort(arr, pivot + 1, right);
        }
    }

    /*
    排序号基准点上的值，并返回基准点的索引
    步骤：
    随机选取一个基准点
    与最右侧的交换
    然后将小于等于这个位置的值与最前面交换 这需要一个变量i做交换
    最后将基准点交换
    返回基准点的index
     */
    private static int partition(int[] arr, int left, int right) {
        int pivot = left + new Random().nextInt(right - left + 1);
        int val = arr[pivot];
        swap(arr, pivot, right);
        int j = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= val) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, j, right);
        return j;
    }

    private static void swap(int[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
