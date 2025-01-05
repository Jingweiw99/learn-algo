package com.wjw.sort;


import java.util.Arrays;

public class QuickSort_ {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivotIndex = partition(arr, left, right);
        quickSort(arr, left, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int k = left;
        int i = left;
        while (i < right) {
            if (arr[i] <= pivot) {
                swap(arr, i, k);
                k++;
            }
            i++;
        }
        swap(arr, k, i);
        return k;
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
