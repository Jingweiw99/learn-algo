package com.wjw;

/*
翻转二叉树
的分解问题解法

定义一个函数的定义，然后用函数的定义来解释你的代码，如果逻辑自洽说明代码是正确的。
 */
public class Lc226_ {
    // 定义函数：  翻转root的左右子节点，然后返回根节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode leftTree = invertTree(root.left);
        TreeNode rightTree = invertTree(root.right);
        root.left = rightTree;
        root.right = leftTree;
        return root;
    }
}

