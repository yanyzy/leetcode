package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/4/25 下午4:22
 */

/**
 * 61. 旋转链表
 * <p>
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head;

        k = k % size(head);

        while (k > 0) {
            ListNode root = newHead;
            while (root.next.next != null) {
                root = root.next;
            }
            ListNode newNode = new ListNode(root.next.val);
            root.next = null;
            newNode.next = newHead;
            newHead = newNode;
            k--;
        }
        return newHead;
    }

    private int size(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        RotateList rotateList = new RotateList();
        System.out.println(rotateList.rotateRight(head, 2000000000));
    }
}
