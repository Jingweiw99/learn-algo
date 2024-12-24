package com.wjw;

/*
从前序和中序中构造二叉树
均无重复元素
 */
public class Lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 先找到前序的第一个作为根节点
        // inorder中找到这个 前面的数组 后面的数组   preorder 中找到对应的 后面的        做递归
//        if (preorder.length == 1 && inorder.length == 1) {
//            return new TreeNode(preorder[0]);
//        }
//        int n = preorder.length;
//        int rVal = preorder[0];
//        // 找到 rVal在inorder的索引
//        int rValIdx = find(rVal, inorder);
//        int[] inArr1 = new int[rValIdx];
//        int[] inArr2 = new int[n - rValIdx - 1];
//        System.arraycopy(inorder, 0, inArr1, 0, rValIdx);
//        System.arraycopy(inorder, rValIdx + 1, inArr2, 0, n - rValIdx - 1);
//
//        int[] preArr1 = new int[rValIdx];
//        int[] preArr2 = new int[n - rValIdx - 1];
//        System.arraycopy(preorder, 1, preArr1, 0, rValIdx);
//        System.arraycopy(preorder, 1 + rValIdx, preArr2, 0, n - rValIdx - 1);
//
//        TreeNode leftTree = buildTree(preArr1,inArr1);
//        TreeNode rightTree = buildTree(preArr2,inArr2);
//        TreeNode root = new TreeNode(rVal);
//        root.left = leftTree;
//        root.right = rightTree;
//        return root;

        return null;
    }

    private int find(int val, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) return i;
        }
        return -1; // 找不到-1 这里是可以找到的
    }

    public static void main(String[] args) {
        Lc105 test = new Lc105();
//        int[] pre = {3, 9, 20, 15, 7};
//        int[] ino = {9, 3, 15, 20, 7};
        int[] pre = {1, 2};
        int[] ino = {2, 1};
        TreeNode treeNode = test.buildTree(pre, ino);
        System.out.println(treeNode);
    }
}
