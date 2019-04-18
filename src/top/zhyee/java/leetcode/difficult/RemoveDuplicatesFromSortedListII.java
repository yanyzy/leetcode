package top.zhyee.java.leetcode.difficult;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/3/25 下午2:05
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        return deleteDuplicates(head, 0);
    }

    public ListNode deleteDuplicates(ListNode head, int count) {
        if (head == null || head.next == null) {
            if (count > 0) {
                return null;
            }
            return head;
        }

        if (head.val == head.next.val) {
            count++;
            return deleteDuplicates(head.next, count);
        } else {
            if (count > 0) {
                return deleteDuplicates(head.next, 0);
            }
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedListII();
        ListNode root = removeDuplicatesFromSortedList.deleteDuplicates(listNode1);

        System.out.println(root);
    }
}
