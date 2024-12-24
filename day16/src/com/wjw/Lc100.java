package com.wjw;

/*
相同的树
 */
public class Lc100 {

    // 判断p，q 树是否是相等的
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            if (p == null && q == null) {
                return true;
            } else {
                return false;
            }
        }
        if (p.val != q.val) return false;
        boolean leftFlag = isSameTree(p.left, q.left);
        if (leftFlag == false) return false;
        boolean rightFlag = isSameTree(p.right, q.right);
        if (rightFlag == false) return false;
        return true;
    }

}
