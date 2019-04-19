package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.ListNode;

import java.util.Stack;

/**
 * @author zhyee
 * @date 2019/4/19 下午4:18
 */
//todo 234
public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            fast = fast.next.next;
            slow = slow.next;
        }

        if (slow.next == null) {
            return stack.peek() == slow.val;
        }

        ListNode cur = slow;

        if (slow.val != stack.peek()) {
            cur = slow.next;
        }

        while (cur != null) {
            if (cur.val == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
            cur = cur.next;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(1);
        System.out.println(palindromeLinkedList.isPalindrome(root));
    }
}
