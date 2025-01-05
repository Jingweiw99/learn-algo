package com.wjw.linkedList;

/*
删除倒数第n个节点
给一个虚拟节点 的next为head 一共需要k+1步能走到null
原head的倒数第n个节点 是原head的k+1-n 个节点 在dummy上需要走k+1-n
那么就先走n步  剩下的就是 k+1   - n 步
 */
public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        int i = n;
        while (i > 0 && p != null) {
            p = p.next;
            i--;
        }
        ListNode p1 = head;
        ListNode p1Pre = null;
        while (p != null) {

            p = p.next;
            if (p == null) {
                p1Pre = p1;
            }
            p1 = p1.next;
        }
        p1Pre.next = p1.next;
        return dummy.next;
    }
}
