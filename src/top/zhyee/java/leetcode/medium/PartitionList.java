package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * 86. 分隔链表
 * <p>
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 * <p>
 * 示例:
 * <p>
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode bigger = new ListNode(0);
        ListNode sNode = smaller;
        ListNode bNode = bigger;
        
        while (head != null) {
            if (head.val < x) {
                sNode.next = new ListNode(head.val);
                sNode = sNode.next;
            } else {
                bNode.next = new ListNode(head.val);
                bNode = bNode.next;
            }
            head = head.next;
        }
        
        sNode.next = bigger.next;
        return smaller.next;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(new PartitionList().partition(head, 3));
    }
}
