package top.zhyee.java.leetcode.difficult;

import top.zhyee.java.leetcode.ListNode;

public class MergekSortedLists {
    
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(4);
        a.next.next = new ListNode(5);
        
        ListNode b = new ListNode(1);
        b.next = new ListNode(3);
        b.next.next = new ListNode(4);
        
        ListNode c = new ListNode(2);
        c.next = new ListNode(6);
        
        System.out.println(new MergekSortedLists().mergeKLists(new ListNode[]{a, b, c}));
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        int count = end - start;
        if (count == 0) {
            return lists[start];
        }
        if (count == 1) {
            return merge(lists[start], lists[end]);
        }
        return merge(mergeKLists(lists, start, start + count / 2), mergeKLists(lists, start + count / 2 + 1, end));
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode root = new ListNode(0);
        ListNode pre = root;
        while (a != null && b != null) {
            if (a.val <= b.val) {
                pre.next = a;
                a = a.next;
            } else {
                pre.next = b;
                b = b.next;
            }
            pre = pre.next;
        }
        
        if (a != null) {
            pre.next = a;
        }
        if (b != null) {
            pre.next = b;
        }
        return root.next;
    }
}
