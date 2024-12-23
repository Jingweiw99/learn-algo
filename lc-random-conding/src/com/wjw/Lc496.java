package com.wjw;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
下一个更大元素1
里面数字各不相同
 */
public class Lc496 {
    // 先用暴力
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        // nums1遍历每次找到nums索引对应的位置中大于这个数的
        // 有关找位置，可以维护一个hashmap nums1索引对应nums2中出现的索引
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map1 = new HashMap<>(); // 不开两个空间只能双循环O(n * n)
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map1.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            map2.put(nums2[i], i);
        }
        for (int i = 0; i < nums1.length; i++) {
            map.put(map1.get(nums1[i]), map2.get(nums1[i]));
        }
        for (int i = 0; i < nums1.length; i++) {
            for (int j = map.get(i) + 1; j < nums2.length; j++) {
                if (nums1[i] < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }

        }
        return res;
    }

    // 单调栈解法
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 通过下面这个方法生成后面一个最大元素的值的数组 然后通过map对应起来。  在num1中遍历找到一下，然后赋值给res
        int[] greaterArr = calculateGreaterElement(nums2);
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], greaterArr[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    // 这个方法利用单调栈生成后面一个最大元素的值的数据
    private static int[] calculateGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? -1 : s.peek();
            s.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] arr = nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(arr)); // -1 3 -1
    }

}
