package com.wjw;

/*
反转链表2

给出一个区间，反转链表
如果 1->2->3  1<=left,right<=3
 */
public class Lc92 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        ListNode newHead = reverseNode(head, 2, 4);
    }

    static ListNode reverseNode(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head), p = dummy;
        // 找到索引left left+1 right right +1的node 相对于p

        ListNode leftPreNode = findNode(p, left - 1);
        ListNode leftNode = leftPreNode.next;
        ListNode rightNode = findNode(p, right);
        ListNode rightNextNode = rightNode.next; // 这里可能rightNextNode为空
        // 做leftNode rightNode之间的改变
        reverseLRNode(leftNode, left, right);
        leftNode.next = rightNextNode;
        leftPreNode.next = rightNode;
        return dummy.next;
    }

    private static void reverseLRNode(ListNode leftNode, int left, int right) {
        ListNode pre = null, cur = leftNode, nxt = leftNode.next;
        while (left != right) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            if (nxt != null) {
                nxt = nxt.next;
            }
            left++;
        }
        cur.next = pre;
    }

    private static ListNode findNode(ListNode head, int index) {
        ListNode p = head;
        while (index > 0) {
            p = p.next;
            index--;
        }
        return p;
    }


}
