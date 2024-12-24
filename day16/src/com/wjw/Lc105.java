package com.wjw;

import java.util.HashMap;

/*
从前序和中序中构造二叉树
均无重复元素
 */
public class Lc105 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    // build函数定义： 前序preorder 范围是preStart preEnd 后续 inorder 范围 inStart inEnd 构造二叉树，返回二叉树根节点。
    // 不使用范围，需要重新给数组，比较麻烦，看之前的解法，后面考虑边界也比较麻烦。
    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        int index = valToIndex.get(rootVal);
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, index);
        return root;
    }


    public static void main(String[] args) {
        Lc105 test = new Lc105();
        int[] pre = {3, 9, 20, 15, 7};
        int[] ino = {9, 3, 15, 20, 7};
//        int[] pre = {1, 2};
//        int[] ino = {2, 1};
        TreeNode treeNode = test.buildTree(pre, ino);
        System.out.println(treeNode);
    }
}
