package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
全排列
 */
public class Lc46 {
    List<List<Integer>> res = new ArrayList<>();

    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return res;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Lc46 test = new Lc46();
        List<List<Integer>> res = test.permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
