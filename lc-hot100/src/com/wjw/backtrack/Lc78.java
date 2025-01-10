package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
子集
 */
public class Lc78 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

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
        System.out.println(test.subsets(new int[]{1, 2, 3}));
    }
}
