package com.wjw;

/*
路径总和
能够找到一条路径等于目标值，返回true
否则false
[5,4,8,11,null,13,4,7,2,null,null,null,1]
分析过程，第一次调用root.left的过程中  最后找到了0 == 0 往上归，最后返回true;
 */
public class Lc112_ {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        targetSum -= root.val;
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}
