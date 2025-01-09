package com.wjw.binaryTree;

/*
将有序数组转成一颗平衡的二叉搜索树
左右子树的高度差不超过1
 */
public class Lc108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    // 定义：以nums 中索引left - right的位置构建一颗平衡二叉搜索树
    private TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
