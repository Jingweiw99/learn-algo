package com.wjw;

/*
二叉树的最近公共祖先
一个关键点是 如果一个二叉树的节点是最近公共祖先，那么这个节点左右树包含有p q。
重叠情况除外
 */
public class Lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        if (root == null) return null;
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.rightright, val1, val2);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
}
