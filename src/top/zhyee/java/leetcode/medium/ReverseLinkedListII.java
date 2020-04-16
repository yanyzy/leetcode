package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;


/**
 * 92. 反转链表 II
 * <p>
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseLinkedListII {
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        int l = n - m;
        dummy.next = head;
        ListNode pre = dummy;
        while (m > 1 && head != null) {
            m--;
            pre = head;
            head = head.next;
        }
        ListNode newNode = new ListNode(head.val);
        ListNode lastNode = newNode;
        head = head.next;
        while (head != null && l > 0) {
            ListNode temp = new ListNode(head.val);
            temp.next = newNode;
            newNode = temp;
            head = head.next;
            l--;
            if (l == 0) {
                lastNode.next = head;
            }
        }
        pre.next = newNode;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        
        System.out.println(new ReverseLinkedListII().reverseBetween(listNode, 2, 4));
        
    }
}
