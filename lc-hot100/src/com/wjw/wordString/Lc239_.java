package com.wjw.wordString;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
滑动窗口的最大值
取k个值，中的最大值放入到数组中
单调栈的解法

主要是在窗口中取最大值 增加了复杂度    如何将O(k) 转变为O(1)？
 */
public class Lc239_ {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new LinkedList<>();
        int[] res = new int[n - k + 1];
        for (int left = 1 - k, right = 0; right < n; left++, right++) {
            if (left - 1 >= 0 && dq.peek() == nums[left - 1]) {
                dq.removeFirst();
            }
            while (!dq.isEmpty() && nums[right] > dq.peekLast()) {
                dq.removeLast();
            }
            dq.addLast(nums[right]);
            if (left >= 0) {
                res[left] = dq.peekFirst();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Lc239_ test = new Lc239_();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3))); // [3,3,5,5,6,7]
    }
}
