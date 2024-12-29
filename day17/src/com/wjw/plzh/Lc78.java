package com.wjw.plzh;

import java.util.ArrayList;
import java.util.List;

/*
元素无重复的数组
找到该数组的所有可能的子集
 */
public class Lc78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // 相当于多叉树的前序遍历，添加到结果中
    private void backtrack(int[] nums, int start) {
        res.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc78 test = new Lc78();
        List<List<Integer>> list = test.subsets(new int[]{1, 2, 3});
        System.out.println(list);
    }
}
