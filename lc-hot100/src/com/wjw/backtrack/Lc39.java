package com.wjw.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
组合总和
注意这题的减枝
一个是start，只包含自己和后面的
一个是排序之后的，如果目标值小于当前遍历的值 后面减枝
 */
public class Lc39 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(track));
            return;
        }
//        if (target < 0) {
//            return;
//        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;
//            System.out.printf("target: %d, candidates[i]: %d \n", target, candidates[i]);
            track.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc39 test = new Lc39();
        List<List<Integer>> lists = test.combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println(lists);
    }
}
