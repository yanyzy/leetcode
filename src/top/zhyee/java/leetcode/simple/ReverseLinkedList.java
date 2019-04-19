package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/4/19 下午3:43
 */


/**
 * 206. 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode next = new ListNode(head.val);
        ListNode root = head;
        while (head.next != null) {
            root = new ListNode(head.next.val);
            head.next = head.next.next;
            root.next = next;
            next = root;
        }

        return root;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        System.out.println(reverseLinkedList.reverseList(root));
    }
}
