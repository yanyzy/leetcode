package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

import java.util.Objects;

/**
 * @author zhyee
 * @date 2018/10/11 下午4:33
 */
public class InsertionSortList2 {

    private ListNode root;

    private ListNode insertionSortList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }

        root = new ListNode(head.val);
        insertionSortList(head.next, root);

        return root;
    }

    private void insertionSortList(ListNode toSort, ListNode newNode) {
        if (Objects.isNull(toSort)) return;

        int x = toSort.val;
        int y = newNode.val;

        if (x <= y) {
            ListNode newRootNode = new ListNode(x);
            newRootNode.next = newNode;
            root = newRootNode;
            insertionSortList(toSort.next, root);
        }

        if (x > y) {
            insertOneToListNode(toSort, root);
            insertionSortList(toSort.next, root);
        }
    }

    private void insertOneToListNode(ListNode one, ListNode root) {
        ListNode sec = root.next;

        if (Objects.isNull(sec)) {
            root.next = new ListNode(one.val);
            return;
        }

        int x = one.val;
        int y = sec.val;

        if (x <= y) {
            ListNode newOne = new ListNode(one.val);
            root.next = newOne;
            newOne.next = sec;
        }

        if (x > y) {
            insertOneToListNode(one, root.next);
        }
    }

    public static void main(String[] args) {
        ListNode ln1 = new ListNode(4);
        ListNode ln2 = new ListNode(2);
        ListNode ln3 = new ListNode(1);
        ListNode ln4 = new ListNode(3);

        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;

        System.out.println(new InsertionSortList2().insertionSortList(ln1));

    }
}
