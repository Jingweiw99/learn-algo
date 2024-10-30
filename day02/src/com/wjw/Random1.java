package com.wjw;

public class Random1 {
    // 1. 需求： 随机函数生成0和1的概率是p,1-p， 变成生成0,1的概率为1/2
    public static int x() {
        return Math.random() < 0.888 ? 0 : 1;
    }

    public static int y() {
        int ans = 0;
        // roll 一次， roll两次，如果相等返回  结果就是返回0,1 1,0才能跳出循环
        do {
            ans = x();
        } while (ans == x());
        return ans;
    }

    public static void main(String[] args) {
        int countX = 0;
        for (int i = 0; i < 100000; i++) {
            if (y() == 0) countX++;
        }
        System.out.println("x的数量为" + countX);
        System.out.println("y的数量为" + (100000 - countX));
    }
}
