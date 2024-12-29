package com.wjw.plzh;

import java.util.ArrayList;
import java.util.List;

/*
组合总和
无重复的candidate，可以重复选数字，等于target
返回全部的可能。

 */
public class Lc39 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, track, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, List<Integer> track, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], track, i); // 可以重复选从i开始
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc39 test = new Lc39();
        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }
}
