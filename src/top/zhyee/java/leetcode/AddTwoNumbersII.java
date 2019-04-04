package top.zhyee.java.leetcode;

import java.util.Stack;

/**
 * @author zhyee
 * @date 2019/4/3 下午2:06
 */


/**
 * 445. 两数相加 II
 *
 * 给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。
 *
 *
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 进阶:
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 * 示例:
 *
 * 输入: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = nodeToStack(l1);
        Stack<Integer> stack2 = nodeToStack(l2);
        Stack<Integer> stack3 = new Stack<>();


        int next = 0;
        int count;

        while (!stack1.empty() && !stack2.empty()) {
            count = stack1.pop() + stack2.pop() + next;
            next = 0;

            if (count >= 10) {
                next = count / 10;
                count = count % 10;
            }
            stack3.push(count);
        }

        if (!stack1.empty()) {
            while (!stack1.empty()) {
                count = stack1.pop() + next;
                next = 0;

                if (count >= 10) {
                    next = count / 10;
                    count = count % 10;
                }
                stack3.push(count);
            }
        } else if (!stack2.empty()) {
            while (!stack2.empty()) {
                count = stack2.pop() + next;
                next = 0;

                if (count >= 10) {
                    next = count / 10;
                    count = count % 10;
                }
                stack3.push(count);
            }
        }

        if (next > 0) {
            stack3.push(next);
        }

        ListNode listNode = new ListNode(stack3.pop());
        ListNode temp = listNode;

        while (!stack3.empty()) {
            temp.next = new ListNode(stack3.pop());
            temp = temp.next;
        }
        return listNode;
    }

    private Stack<Integer> nodeToStack(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        return stack;
    }
}
