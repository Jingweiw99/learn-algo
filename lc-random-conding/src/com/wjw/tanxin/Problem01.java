package com.wjw.tanxin;

public class Problem01 {
    // 凑出amount金额，纸币的选择是coins，最少需要多少枚硬币
    /*
    如果这题使用贪心算法，
    考虑场景，3 [1, 100] 那么每次我们选择大的硬币 100 这是局部的最优解，但是不能推导出全局的最优解。
    这不符合贪心选择性质
    只能通过枚举全部的选择来获取凑出对应的金额的 需要的最少硬币数量
    返回-1 表示无法凑出对应的数量的金额
     */
    public int minCoin(int amount, int[] coins) {
        if (amount == 0) return 0;
        for (int coin : coins) {
            // 如果当前的coin大于amount，那么continue
            // 如果是小于等于的话，我们减去这个值amount = amount - coin
            if (coin > amount) continue;
            return 1 + minCoin(amount - coin, coins);
        }
        // 如果到了这里说明直接找不到了
        return Integer.MIN_VALUE;
    }

    public static void main(String[] args) {
        Problem01 test = new Problem01();
        System.out.println(test.minCoin(3, new int[]{100, 2}));
    }
}
