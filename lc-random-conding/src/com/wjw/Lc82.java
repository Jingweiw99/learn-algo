package com.wjw;

/*
删除排序链表中的重复元素  重复的元素全部删除
过后思路梳理：
删除全部的重复节点，不能直接找到不重复的节点就设置上，因为不和前面重复，有可能和后面重复。
需要添加到判断不相等之后再加
还有一个注意点是，在添加的时候直接新创建节点，不然后面有的会没有断开连接。
 */
public class Lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1), p1 = dummy;
        ListNode p = head;
        while (p != null) {
            if (p.next == null) {
                p1.next = p;
                break;
            }
            if (p.val == p.next.val) {
                int dupVal = p.val; // 重复的值
                while (p != null && p.val == dupVal) {
                    p = p.next;
                }
            } else {
                p1.next = new ListNode(p.val);
                p1 = p1.next;
                p = p.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4))))));
//        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2)));
        Lc82 test = new Lc82();
        ListNode newHead = test.deleteDuplicates(head);
        System.out.println(newHead);

    }
}
