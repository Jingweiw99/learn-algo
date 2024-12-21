package com.wjw;

import java.util.Stack;

public class Test {
    public static void reorderList(ListNode head) {
        // 给一个栈，将head放入栈
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }
        p = head;

        while (p != null) {
            ListNode pNext = p.next;
            ListNode lastNode = stack.pop();
            if (pNext == lastNode || lastNode.next == pNext) {
                lastNode.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = pNext;
            p = p.next;
        }
    }

    public static void main(String[] args) {
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
    }
}
