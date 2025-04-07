package com.wjw;

/*
爱生气的书店老板
customers[i] 表示第i分钟有多少顾客
grumpy[i] 如果为1表示第i分钟老板生气
minute表示可以在这个时间段不生气
求书店一天内满意的最大值
 */
public class Lc1052 {
    // 这个能通过一半的测试用例
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int maxSatisfied = 0;
        int sum = 0; // 每轮的顾客
        int n = grumpy.length;
        // 枚举grumpy，将当前三个位置上的值添加上，其他位置计算  计算之后可以更新最大值
        for (int i = 0; i < n; i++) {
            if (i < minutes - 1) continue;
            // 0 - i - 1  i  i+ minutes - 1   i+minutes ~ n - 1
            for (int j = 0; j < n; j++) {
                if (j >= i && j < i + minutes) {
                    sum += customers[j];
                } else {
                    if (grumpy[j] == 0) {
                        sum += customers[j];
                    }
                }
            }
            maxSatisfied = Math.max(maxSatisfied, sum);
            sum = 0;
        }
        return maxSatisfied;
    }

    public static void main(String[] args) {
        Lc1052 test = new Lc1052();
        int[] customers = {1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = {0, 1, 0, 1, 0, 1, 0, 1};
        int minutes = 3;
        System.out.println(test.maxSatisfied(customers, grumpy, minutes)); //
    }
}
