package com.wjw.linked;

/*
找到倒数第k个节点，
题目不会给n的大小，所以找到n-k-1个节点，需要遍历一次找到n，需要再遍历找到n-k-1

先走k步，然后走n-k步到达最后点
 */
public class FindFromEndK {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null) return null;
        ListNode p1 = head, p2 = head; // p1用来找到倒数第n个节点
        while(n > 0) {
            p2 = p2.next;
            n--;
        }
        ListNode p1Pre = head;
        while(p2 != null) {
            // 找到p1的前面节点
            p1Pre = p1;
            p1= p1.next;
            p2 = p2.next;
        }
        p1Pre.next = p1.next;
        return head;
    }
    // 找到head的倒数第k个节点 ，返回
    static ListNode findFromEndK(ListNode head, int k) {
        ListNode p = head;
        ListNode p1 = head;
        while (p1 != null && k > 0) {
            p1 = p1.next;
            k--;
        }
        while (p1 != null) {
            p = p.next;
            p1 = p1.next;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(4, new ListNode(5)))));
        ListNode head2 = new ListNode(1, new ListNode(2));
//        ListNode target = findFromEndK(head, 2);// 1->2->3->4->5 倒数第二个节点是4
        ListNode newHead = removeNthFromEnd(head2, 1);// 1->2->3->5
        System.out.println(newHead);
    }
}
