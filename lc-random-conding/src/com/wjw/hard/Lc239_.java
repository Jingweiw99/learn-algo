package com.wjw.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
使用单调栈来求解 滑动窗口最大值的问题
每次滑动的过程中，都放入到窗口中（窗口是一个单调队列，可以方便的获取最大值）
 */
public class Lc239_ {
    // 需要实现push pop max方法 数据由双向链表保存
    private static class MonotonicQueue {
        LinkedList<Integer> maxq = new LinkedList<>();

        public void push(int n) {
            while (!maxq.isEmpty() && maxq.getLast() < n) {
                maxq.pollLast();
            }
            maxq.offerLast(n);
        }

        // 需要等于n才弹，因为之前的最头部也会被弹出来
        public void pop(int n) {
            if (maxq.peek() == n) {
                maxq.pollFirst();
            }
        }

        public int max() {
            return maxq.peek();
        }

        public boolean isEmpty() {
            return maxq.isEmpty();
        }
    }

    /*
    有了单调栈之后，
    滑动窗口大小k 每次记录里面的最大值
    先右添加一个，然后左收缩
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue mq = new MonotonicQueue();
        List<Integer> maxList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < k) {
                mq.push(nums[i]);
                continue;
            }
            mq.push(nums[i]);
            maxList.add(mq.max());// 这里不好确定每个i怎么放，通过List给，然后转int[] 得到最后结果
            mq.pop(nums[i - k + 1]); // 最尾的元素找到头的元素
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < maxList.size(); i++) {
            res[i] = maxList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {1, 3, 1, 2, 0, 5};
        int k = 3;
        int[] maxSliding = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(maxSliding)); // 3, 3, 5, 5, 6, 7


        // test MonotonicQueue
//        test1();
    }

    public static void test1() {
        MonotonicQueue mq = new MonotonicQueue();
        mq.push(3);
        mq.push(2);
        System.out.println(mq.max()); // 3
        mq.push(4);
        System.out.println(mq.max()); // 4
        mq.pop(4); // 4将之前的都弹出了 所以最后弹出4就为空了
        System.out.println(mq.isEmpty()); //true
    }
}
