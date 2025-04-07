package com.wjw.design;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 1, 2};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    // left - right 排好序
    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    private static Random ran = new Random();

    // 排好pivot的位置上的 左边都比pivot小，右边都比pivot大
    public static int partition(int[] nums, int left, int right) {
        // 选取一个随机点，与最后一个位置交换
        // 小于这个数 添加到左边 需要给一个指针 一个遍历的
        int index = ran.nextInt(right - left + 1) + left;
        int val = nums[index];
        swap(nums, index, right);
        int cur = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] <= val) {
                swap(nums, cur, i);
                cur++;
            }
        }
        // 最后一个位置上的值与当前的位置交换，return index
        swap(nums, cur, right);
        return cur;
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
