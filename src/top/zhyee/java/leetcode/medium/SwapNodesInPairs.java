package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * 24. 两两交换链表中的节点
 * <p>
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (head != null) {
            if (head.next == null) {
                break;
            }
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            pre = head;
            head = head.next;
        }
        return dummy.next;
    }
}
