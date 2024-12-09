package com.wjw;

public class Test {
    // 基本的二叉树节点
    static class TreeNode {
        int val;
        TreeNode left, right;
        public TreeNode(int i) {
            this.val = i;
        }
    }

    // 二叉树的遍历框架  需要深度理解二叉树的遍历过程，和每个节点进入进出的关系。
    // 前中后序节点都要每个位置的代码都需要了解清楚！！！
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        System.out.println(root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        traverse(root);
    }
}
