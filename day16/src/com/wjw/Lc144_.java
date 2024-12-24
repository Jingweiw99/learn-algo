package com.wjw;

import java.util.ArrayList;
import java.util.List;

/*
分解问题，求前序遍历的所有结果收集

前序遍历是根 左 右
题目定义这个函数是给一个节点，返回它的前序遍历结果。
那么可以定义为 根结果 + 左子树的结果 + 右子树的结果
 */
public class Lc144_ {
    List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(preorderTraversal(root.left));
        res.addAll(preorderTraversal(root.right));
        return res;
    }

}
