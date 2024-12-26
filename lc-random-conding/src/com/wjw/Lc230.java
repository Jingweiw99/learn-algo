package com.wjw;


/*
二叉搜索树的第k小的元素
 */
public class Lc230 {
    int res;
    int rank = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        if (root == null) return;

        traverse(root.left, k);
        rank++;
        if (rank == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }

    public static void main(String[] args) {
        Lc230 test = new Lc230();
        TreeNode root = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        int res = test.kthSmallest(root, 2);
        System.out.println(res);
    }
}
