package com.wjw.binaryTree;

import java.util.HashMap;

/*
从前序和中序构造出二叉树
preorder 和 inorder是无重复元素的

注意索引和长度的计算
左索引 + 长度 - 1   = 右索引
右索引 - 左索引 = 长度 - 1
 */
public class Lc105 {
    private HashMap<Integer, Integer> preValToIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preValToIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            preValToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd)
            return null;
//        System.out.printf("preStart: %d \n", preStart);
        int rootVal = preorder[preStart];
        int index = preValToIndex.get(rootVal);
        int leftSize = index - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Lc105().buildTree(preorder, inorder);
        System.out.println(treeNode);
    }
}
