package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/25 下午4:43
 */


/**
 * 725. 分隔链表
 *
 * 给定一个头结点为 root 的链表, 编写一个函数以将链表分隔为 k 个连续的部分。
 *
 * 每部分的长度应该尽可能的相等: 任意两部分的长度差距不能超过 1，也就是说可能有些部分为 null。
 *
 * 这k个部分应该按照在链表中出现的顺序进行输出，并且排在前面的部分的长度应该大于或等于后面的长度。
 *
 * 返回一个符合上述规则的链表的列表。
 *
 * 举例： 1->2->3->4, k = 5 // 5 结果 [ [1], [2], [3], [4], null ]
 *
 * 示例 1：
 *
 * 输入:
 * root = [1, 2, 3], k = 5
 * 输出: [[1],[2],[3],[],[]]
 * 解释:
 * 输入输出各部分都应该是链表，而不是数组。
 * 例如, 输入的结点 root 的 val= 1, root.next.val = 2, \root.next.next.val = 3, 且 root.next.next.next = null。
 * 第一个输出 output[0] 是 output[0].val = 1, output[0].next = null。
 * 最后一个元素 output[4] 为 null, 它代表了最后一个部分为空链表。
 * 示例 2：
 *
 * 输入:
 * root = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], k = 3
 * 输出: [[1, 2, 3, 4], [5, 6, 7], [8, 9, 10]]
 * 解释:
 * 输入被分成了几个连续的部分，并且每部分的长度相差不超过1.前面部分的长度大于等于后面部分的长度。
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int size = size(root);
        int length = size / k;
        int remainder = size % k;
        ListNode[] listNodes = new ListNode[k];
        ListNode head = root;

        for (int i = 0; i < k; i++) {

            if (head == null) {
                continue;
            }
            int tempLen = length;
            if (remainder > 0) {
                tempLen = length + 1;
                remainder--;
            }
            ListNode newNode = head;
            while (tempLen > 1 && newNode != null) {
                newNode = newNode.next;
                tempLen--;
            }
            ListNode newnode = newNode.next;
            newNode.next = null;
            listNodes[i] = head;
            head = newnode;
        }
        return listNodes;
    }

    private int size(ListNode root) {
        int size = 0;
        while (root != null) {
            root = root.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        SplitLinkedListInParts splitLinkedListInParts = new SplitLinkedListInParts();
        System.out.println(Arrays.toString(splitLinkedListInParts.splitListToParts(root, 5)));
    }
}
