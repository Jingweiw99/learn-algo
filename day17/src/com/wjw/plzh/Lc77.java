package com.wjw.plzh;

import java.util.ArrayList;
import java.util.List;

/*
组合问题
是Lc78那题只收集到对应的层数

 */
public class Lc77 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> track = new ArrayList<>();
        backtrack(n, k, 1, track);
        return res;
    }

    private void backtrack(int n, int k, int start, List<Integer> track) {
        if (track.size() == k) {
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1, track); // 这里画图分支 应该是i+1 比如我选择1之后可以选择[2,3,4]，  然后回到[2,3,4]这个选择节点上，这个时候应该选择3 这里是i+1才是选择3，不然还是从start的2开始
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        Lc77 test = new Lc77();
        System.out.println(test.combine(4, 2)); // 12 13 23
    }

}
