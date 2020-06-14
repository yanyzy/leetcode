package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.ListNode;

public class LCOF {
    
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
    
    private ListNode reverse(ListNode node) {
        ListNode head = node;
        while (node != null && node.next != null) {
            ListNode temp = node.next;
            node.next = node.next.next;
            temp.next = head;
            head = temp;
        }
        return head;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(new LCOF().reverseList(head));
    }
}
