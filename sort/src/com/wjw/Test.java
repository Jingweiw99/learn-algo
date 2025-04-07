package com.wjw;

import java.util.Arrays;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        int[] nums = {5,4,2,3,1};
        quickSort(nums, 0, nums.length -1 );
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums,int left, int right) {
        if(left >= right) return;
        // 排序好pivot上的值，然后返回这个值
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private static Random ran = new Random();
    public static int partition(int[] nums, int left, int right) {
        // 随机获取一个值 [left, right + 1)
        int index = left + ran.nextInt(right - left + 1);
        int val = nums[index];
        // 与最后一个位置上的值交换
        swap(nums, index, right);
        // 小于等于这个位置上的值放左边，找到最后的pivot，然后这个位置上的值已经排好
        int k = left;
        for(int i = left; i < right; i++) {
            if(nums[i] <= val) {
                swap(nums, i, k);
                k++;
            }
        }
        swap(nums, k, right);
        return k;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
