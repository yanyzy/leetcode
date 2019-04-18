package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/3/26 上午11:11
 */
public class LinkedListCycleII {

    public ListNode detectCycle(ListNode head) {

        ListNode meet = hasCycle(head);

        if (meet != null) {

            while (true) {
                if (meet == head) {
                    return meet;
                }
                meet = meet.next;
                head = head.next;
            }

        }

        return null;
    }

    private ListNode hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        try {
            fast = fast.next.next;
            slow = slow.next;

            while (fast.next.next != null && slow.next != null) {
                if (fast == slow) {
                    return fast;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
        } catch (NullPointerException e) {
            return null;
        }
        return null;
    }
}
