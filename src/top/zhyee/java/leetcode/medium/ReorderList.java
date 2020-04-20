package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * 143. 重排链表
 *
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {
    
    //todo
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverser = reverser(slow.next);
        
        ListNode node = head;
        while (node != null && reverser != null) {
            ListNode temp = reverser;
            temp.next = node.next;
            node.next = temp;
            node = node.next.next;
            reverser = reverser.next;
        }
    }
    
    private ListNode reverser(ListNode head) {
        ListNode p1 = head;
        while (head != null) {
            ListNode temp = head.next;
            p1.next = temp;
            temp.next = head;
            head = head.next;
        }
        return p1;
    }
    
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        new ReorderList().reorderList(listNode);
        System.out.println(listNode);
    }
}
