package com.wjw.binaryTree;


/*
二叉树的最大深度
分解问题
maxDepth函数定义：输入二叉树root 返回root的最大深度
maxDepth(root) = maxDepth(root.left),maxDepth(root.right) 的一个较大的值 + 1
 */
public class Lc104__ {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        Lc104__ test = new Lc104__();
        System.out.println(test.maxDepth(root)); // 3
    }
}
