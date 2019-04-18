package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * @author zhyee
 * @date 2019/4/18 下午3:18
 */


/**
 * 147. 对链表进行插入排序
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {

        if(head==null){
            return null;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val < pre.val) {
                //向前移动该结点
                pre.next = cur.next;
                head = move(head, cur);
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }

    private ListNode move(ListNode head,  ListNode cur) {
        ListNode root = head;
        if (cur.val <= head.val) {
            cur.next = head;
            return cur;
        }

        while (root.next != null) {
            if (cur.val <= root.next.val) {
                cur.next = root.next;
                root.next = cur;
                return head;
            }
            root = root.next;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(4);
        root.next = new ListNode(2);
        root.next.next = new ListNode(1);
        root.next.next.next = new ListNode(3);

        InsertionSortList insertionSortList = new InsertionSortList();
        System.out.println(insertionSortList.insertionSortList(root));
    }
}
