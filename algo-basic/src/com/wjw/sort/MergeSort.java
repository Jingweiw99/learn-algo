package com.wjw.sort;

import java.util.Arrays;

/*
归并排序
稳定的排序，时间复杂度O(nlogn)
需要临时数组 在merge中体现
 */
public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int[] temp = new int[arr.length]; // 临时数组用于合并
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    // 递归分解数组
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    // 合并两个有序子数组
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        // 将两个子数组的元素按顺序合并到临时数组中 会剩下左右剩余的情况
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        k = 0;
        while (left <= right) {
            arr[left++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1}; // 过程就是递归分解到 4 2 3 1 然后 4 2 排序成24  回到右 3 1 排序成 1 3  然后回到 0 3的索引 然后 排序成 1234
        System.out.println("排序前: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("排序后: " + Arrays.toString(arr));
    }

}
