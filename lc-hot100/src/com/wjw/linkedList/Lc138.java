package com.wjw.linkedList;

import java.util.HashMap;

/*
随机链表的复制
 */
public class Lc138 {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        Node p = head;
        Node dummy = new Node(-1), d = dummy;
        HashMap<Node, Node> oriToClone = new HashMap<>();
        while (p != null) {
            oriToClone.put(p, new Node(p.val));
            p = p.next;
        }
        p = head;
        while (p != null) {
            if (d == dummy) {
                d.next = oriToClone.get(p);
                d = d.next;
                continue;
            }
            d.next = oriToClone.get(p.next);
            d.random = oriToClone.get(p.random); // map get null也是null
            d = d.next;
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.next = null;
        node2.random = node2;
        Node node = copyRandomList(node1);
        System.out.println(node);
    }
}
