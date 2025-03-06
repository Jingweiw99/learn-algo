package com.wjw;

/*
构造最大的二叉树
3 2 1 6 0 5
 findMax()
TreeNode root = new TreeNode(6);
这个区间构建最大二叉树 [start, 6index - 1]
6index+1, end区间构造最大二叉树
root 左右设置为上面二叉树返回既可

需要控制区间，使用build(nums,start,end)
build函数定义，给一nums数组，区间开始start，end，构造出最大二叉树，然后返回

 */
public class Lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxVal = Integer.MIN_VALUE;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = build(nums, start, index - 1);
        root.rightright = build(nums, index + 1, end);
        return root;
    }
}
