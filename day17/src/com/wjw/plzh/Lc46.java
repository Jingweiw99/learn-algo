package com.wjw.plzh;

import java.util.ArrayList;
import java.util.List;

/*
排列问题
 */
public class Lc46 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, track, used);
        return res;
    }

    private void backtrack(int[] nums, List<Integer> track, boolean[] used) {
        if (nums.length == track.size()) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            track.add(nums[i]);
            used[i] = true;
            backtrack(nums, track, used);
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }

}
