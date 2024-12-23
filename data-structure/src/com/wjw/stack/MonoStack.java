package com.wjw.stack;

import java.util.Arrays;
import java.util.Stack;

/*
单调栈
现在给一场景，
返回一个新的数组
就是找到后面的一个大于当前元素，赋值到当前位置，找不到返回-1

有两种方式：
第一种通过暴力，初始化设置为-1，然后找到后面一个大的值，然后记录一下，break
第二种方式通过单调栈，可以优化时间复杂度到o(n)
 */
public class MonoStack {
    // 这里给出第二种方式
    public static int[] calculateGreaterElement(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    // 也给一下第一种方式吧
    public static int[] calculateGreaterElement2(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    res[i] = nums[j];
                    break; // 不加break不是找到的第一个大于当前的值，是最后一个。
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 3, 1};
        int[] newNums = calculateGreaterElement(nums);
        int[] newNums2 = calculateGreaterElement2(nums);
        System.out.println(Arrays.toString(newNums)); // 2 4 -1 -1 -1
        System.out.println(Arrays.toString(newNums2)); // 2 4 -1 -1 -1
    }
}
