package com.wjw.binaryTree;

/*
翻转二叉树
invertTree： 反转这个二叉树，并返回根节点
翻转 root 等价于翻转root.left 翻转root.right 然后左右交换位置
 */
public class Lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);
        root.left = rightNode;
        root.right = leftNode;
        return root;
    }
}
