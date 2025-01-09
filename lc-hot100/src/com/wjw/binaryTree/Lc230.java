package com.wjw.binaryTree;

/*
二叉搜索树中第k小的元素
核心思路： 想到二叉搜索树的中序遍历，然后在中序遍历代码中，我们去走k次，然后返回这个节点的值
 */
public class Lc230 {
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    int rank = 0;
    int res = -1;

    private void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
        }
        traverse(root.right, k);
    }
}
