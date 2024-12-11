package com.wjw.linked;

import java.util.PriorityQueue;

/*
找到有序二维矩阵的第k大的值

 */
public class Lc378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < matrix.length; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        while (!pq.isEmpty() && k > 0) {
            int[] val = pq.poll();
            if (k == 1) return val[0];
            k--;
            int i = val[1];
            int j = val[2];
            if (j + 1 < matrix.length) {
                pq.offer(new int[]{matrix[i][j + 1], i, j + 1});
            }
        }
        return -1;
    }
}
