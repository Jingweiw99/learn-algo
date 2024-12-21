package com.wjw;

import java.util.Stack;

/*
重排链表

 */
public class Lc143 {
    public static void reorderList(ListNode head) {
        // 初始化一个栈， 遍历链表放入到栈中
        Stack<ListNode> s = new Stack<>();
        ListNode p = head;
        while (p != null) {
            s.push(p);
            p = p.next;
        }
        p = head;
        while (p != null) {
            ListNode lastNode = s.pop();
            ListNode nxt = p.next;
            if (lastNode == nxt || lastNode.next == nxt) { // 这个结束条件的判断 调试得出偶数个数的时候通过第一个break， 奇数通过第二个退出循环。
                p.next = null;
                break;
            }
            p.next = lastNode;
            lastNode.next = nxt;
            p = nxt;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reorderList(head);
    }
}
