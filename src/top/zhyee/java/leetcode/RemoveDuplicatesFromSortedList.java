package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/25 下午1:32
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.val == head.next.val) {
            return deleteDuplicates(head.next);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(1);
        listNode1.next.next = new ListNode(2);
        listNode1.next.next.next = new ListNode(3);
        listNode1.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode root = removeDuplicatesFromSortedList.deleteDuplicates(listNode1);

        System.out.println(root);
    }
}
