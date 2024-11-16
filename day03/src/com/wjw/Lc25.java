package com.wjw;

/*
hard
k个一组反转
 */
public class Lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode protect = new ListNode(0,head);
        ListNode last = protect; // 上一组变换之后的结尾
        // 分组遍历（找到头和结尾）遍历中修改
        while(head!=null) {
            ListNode end =  getEnd(head,k);
            if(end ==null) break;
            ListNode nextHeadGroup = end.next; // 下一组的头，不是变换后的头
            reverseNode(head,end);
            // 上一组的头结点与本组的新节点建立联系
            last.next = end;
            head.next = nextHeadGroup;
            // 分组遍历
            last = head;
            head = nextHeadGroup;
        }
        return protect.next;
    }
    // 获取k个链表最后的一个链表
    private ListNode getEnd(ListNode head, int k) {
        while (head != null) {
            k--;
            if (k == 0) {
                break;
            }
            head = head.next;
        }
        return head;
    }
    // 这里反转了链表中间的，不需要反转开头的
    private void reverseNode(ListNode head,ListNode end) {
        if(head == end) return;
        ListNode pre = head;
        head = head.next;
        while (pre != end) {
            ListNode headNext = head.next;
            head.next = pre;
            pre = head;
            head = headNext;
        }
    }
}
