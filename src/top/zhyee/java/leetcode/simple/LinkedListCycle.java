package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/3/26 上午10:17
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        try {
            fast = fast.next.next;
            slow = slow.next;

            while (fast.next.next != null && slow.next != null) {
                if (fast == slow) {
                    return true;
                }
                fast = fast.next.next;
                slow = slow.next;
            }
        } catch (NullPointerException e) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = listNode.next;

        System.out.println(new LinkedListCycle().hasCycle(listNode));
    }


}
