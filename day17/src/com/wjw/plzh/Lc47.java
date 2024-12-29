package com.wjw.plzh;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
全排列2
可以有重复数字的数组，返回全排列

 */
public class Lc47 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        if (nums.length == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        Lc47 test = new Lc47();
        System.out.println(test.permuteUnique(new int[]{3, 3, 3, 0}));
    }
}
