package com.wjw;

/*
这里收集的是回溯算法相关题目
 */
public class Test {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
    }
}
