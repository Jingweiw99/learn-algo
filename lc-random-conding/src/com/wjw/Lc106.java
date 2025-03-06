package com.wjw;


import java.util.HashMap;

/*
从中序和后序遍历构造二叉树

 */
public class Lc106 {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    // inorder inStart开始 inEnd结束的前序遍历 postorder postStart postEnd的后序遍历，构造出二叉树，并返回。
    private TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) { // 只要inStart > inEnd postStart也会大于inEnd
            return null;
        }
        int rootVal = postorder[postEnd];
        // 后续遍历的这个根值，找到中序遍历中的值 由于值不同，通过HashMap来先保存值
        int rootIndex = valToIndex.get(rootVal);
        int preLen = rootIndex - inStart;
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + preLen - 1);
        root.rightright = build(inorder, rootIndex + 1, inEnd, postorder, postStart + preLen, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        Lc106 test = new Lc106();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode root = test.buildTree(inorder, postorder);
        System.out.println(root);
    }
}
