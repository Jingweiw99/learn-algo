package com.wjw.plzh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
集合带有重复元素的子集
 */
public class Lc90 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> track = new ArrayList<>();
        backtrack(nums, 0, track);
        return res;
    }

    private void backtrack(int[] nums, int start, List<Integer> track) {
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue; // 注意分支在代码中的表现
            track.add(nums[i]);
            backtrack(nums, i + 1, track);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc90 test = new Lc90();
        List<List<Integer>> lists = test.subsetsWithDup(new int[]{1, 2, 2});
        System.out.println(lists);
    }
}

