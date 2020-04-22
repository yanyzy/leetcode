package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

import java.util.Stack;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1:
 * <p>
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 * <p>
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reorder-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReorderList {
    
    /**
     * 1.使用快慢指针找出中点，分割链表
     * 2.将第二段链表反转
     * 3.将反转后的第二段链表插入第一段链表中
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverser = reverser(slow.next);
        slow.next = null;
        
        while (head != null && reverser != null) {
            ListNode temp = head.next;
            head.next = reverser;
            reverser = reverser.next;
            head.next.next = temp;
            head = head.next.next;
        }
    }
    
    private ListNode reverser(ListNode head) {
        if (head == null) {
            return head;
        }
        Stack<ListNode> nodes = new Stack<>();
        while (head != null) {
            nodes.push(head);
            head = head.next;
        }
        
        ListNode newHead = nodes.pop();
        ListNode node = newHead;
        while (!nodes.empty()) {
            ListNode temp = nodes.pop();
            temp.next = null;
            node.next = temp;
            node = node.next;
        }
        return newHead;
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
