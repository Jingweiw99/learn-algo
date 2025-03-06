package com.wjw.test;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int val;
    Node[] children;

    public static void main(String[] args) {
        // 测试这两个位置的执行的代码顺序
        Node node1 = new Node();
        node1.val = 1;
        Node node2 = new Node();
        node2.val = 2;
        node2.children = new Node[]{};
        Node node3 = new Node();
        node3.val = 3;
        node3.children = new Node[]{};
        Node node4 = new Node();
        node4.val = 4;
        node4.children = new Node[]{};

        node1.children = new Node[]{node2, node3, node4};

//        levelTraverse(node1);
        traverse(node1);

    }

    public static void traverse(Node node) { // 以这个节点为栈的开始，里面的前序执行的代码是进入该节点的时候执行的代码
        if (node == null) return;
        System.out.println("前序位置的val" + node.val);
        for (Node child : node.children) {
            traverse(child);
        }
        System.out.println("后续位置的val" + node.val);
    }

    public static void levelTraverse(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        int depth = 0;
        while (!q.isEmpty()) {
            // 如果需要添加上层级
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Node cur = q.poll();
                // 然后当前节点的子节点添加到队列中
                for (Node child : cur.children) {
                    if (child != null) q.offer(child);
                }
            }
            depth++;
        }
        System.out.println(depth);
    }
}
