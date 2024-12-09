package com.wjw.dp;

public class Fib {
    public static void main(String[] args) {
        Fib fib = new Fib();
        // 1 1 2 3 5 8 ....
        int num = fib.fib2(6);
        System.out.println(num);

        System.out.println(fib.fib3(6));

        System.out.println(fib.fib4(4));
    }

    // 暴力递归求fib的结果
    int fib(int n) {
        if (n == 1 || n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    // 带有memo fib 减少重复计算
    int fib2(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 1;
        int res = fibMemo(n, memo);
        return res;
    }

    private int fibMemo(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fibMemo(n - 1, memo) + fibMemo(n - 2, memo);
        return memo[n];
    }

    // 转换为自底向上的dp数组形式 dp表 dp[n] 表示 第n个fib数是多少
    int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 这里推演的过程其实就是dp的优化思想，从暴力递归，找到冗余的计算带有备忘录的递归，这都是自顶向下的计算。。
    // 受备忘录的启发，直接自底向上递推每个值。这就是动态规划的基本思想

    // 然后压缩 空间
    int fib4(int n) {
        if (n == 1 || n == 2)
            return 1;
        int dp = 0;
        int dp_n_1 = 1;
        int dp_n_2 = 1;
        for (int i = 3; i <= n; i++) {
            dp = dp_n_1 + dp_n_2;
            int temp = dp_n_1;
            dp_n_1 = dp;
            dp_n_2 = temp;
        }
        return dp;

    }
}
