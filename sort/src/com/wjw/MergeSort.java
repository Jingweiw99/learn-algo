package com.wjw;

import java.util.Arrays;

/*
归并排序
给一个数组排好序
先递归分解到最后一个数，然后进行合并
 */
public class MergeSort {
    public void mergeSort(int[] nums) {
        int left = 0, right = nums.length - 1;
        sort(nums, left, right);
    }

    // 将nums的[left，right]排好序
    private void sort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    /*
    将nums的[left, mid] [mid+1,right]合并
    这里的temp数组也可以在这个merge函数里面声明长度为 right - left + 1
     */
    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left, r = mid + 1;
        int k = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[k++] = nums[l++];
            } else {
                temp[k++] = nums[r++];
            }
        }
        while (l <= mid) {
            temp[k++] = nums[l++];
        }
        while (r <= right) {
            temp[k++] = nums[r++];
        }
        // 将temp的数据放到nums中 left - right nums是从left-right temp是从0-k-1
        k = 0;
        while (left <= right) {
            nums[left++] = temp[k++];
        }
    }

    // 归并排序 非递归版本
    public void mergesort2(int[] nums) {
        if (nums == null || nums.length < 2)
            return;
        int n = nums.length;
        // 外层循环 当mergeSize < n 的时候循环
        int mergeSize = 1;
        while (mergeSize < n) {
            int left = 0;
            // 内层循环分组循环 每组然后排序成功这组 如果当前的 n < mergeSize 说明不用排序了。
            while (left < n) {
                int mid = left + mergeSize - 1;
                if (mid >= n)
                    break;
                int right = Math.min(mid + mergeSize, n - 1);
                merge(nums, left, mid, right);
                left = right + 1;
            }
            // 这里为了防止整型溢出
            if (mergeSize > n / 2)
                break;
            mergeSize = mergeSize << 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 5, 4, 3, 2, 1};
        MergeSort test = new MergeSort();
        test.mergesort2(nums);
        System.out.println(Arrays.toString(nums)); // 1 2 3 4 5 6
    }
}
