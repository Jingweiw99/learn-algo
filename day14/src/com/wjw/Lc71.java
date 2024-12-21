package com.wjw;

import java.util.Stack;

/*
简化路径
 */
public class Lc71 {
    public static String simplifyPath(String path) {
        // 这个中间的一共有这几种情况， . .. 空 目录 的条件 . 空不管，如果是..弹出来，目录push
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String s : paths) {
            if (s.isEmpty() || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;
        }
        return res.equals("") ? "/" : res;
    }

    public static void main(String[] args) {
//        String path = "/home//foo/";
//        String path = "/home/../foo/";
//        String path = "/../foo/";
        String path = "/../"; // 预期结果是/
        System.out.println(simplifyPath(path));
    }
}
