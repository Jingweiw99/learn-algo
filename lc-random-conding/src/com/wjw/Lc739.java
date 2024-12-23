package com.wjw;

import java.util.Arrays;
import java.util.Stack;

public class Lc739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }
            res[i] = s.isEmpty() ? 0 : (s.peek() - i);
            s.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr = dailyTemperatures(temp);
        System.out.println(Arrays.toString(arr));
    }
}
