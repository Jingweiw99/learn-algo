package com.wjw;

import java.util.PriorityQueue;

public class Lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[0] - b[0];
        });
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        int rowLen = matrix[0].length;
        int res = Integer.MAX_VALUE;
        while (!pq.isEmpty() && k > 0) {
            int[] info = pq.poll();
            res = info[0];
            int i = info[1], j = info[2];
            if (j + 1 < rowLen) {
                pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
            k--;
        }
        return res;
    }
}
