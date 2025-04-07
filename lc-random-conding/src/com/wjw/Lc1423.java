package com.wjw;

/*

 */
public class Lc1423 {
    public int maxScore(int[] cardPoints, int k) {
        // 这里会枚举左右段点
        int n = cardPoints.length;
        // 首先计算前k个数的和
        // 枚举i = 1 ~ k 每次枚举 sum 加上倒数第i个(倒数第i个的索引是n-i) 减去第k-i个数（第k-i个数的索引是k-i+1）
        int sum = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        max = sum;
        for (int i = 1; i <= k; i++) {
            sum += (cardPoints[n - i] - cardPoints[k - i]);
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        Lc1423 test = new Lc1423();
        System.out.println(test.maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3)); // 12
    }
}

