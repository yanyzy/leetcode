package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/24 下午4:28
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }

        ListNode root = null;
        ListNode current = null;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                if (root == null) {
                    root = new ListNode(l2.val);
                    current = root;
                } else {
                    current.next = new ListNode(l2.val);
                    current = current.next;
                }
                l2 = l2.next;
            } else {
                if (root == null) {
                    root = new ListNode(l1.val);
                    current = root;
                } else {
                    current.next = new ListNode(l1.val);
                    current = current.next;
                }
                l1 = l1.next;
            }
        }

        if (l1 == null && l2 != null) {
            while (l2.next != null) {
                current.next = new ListNode(l2.val);
                current = current.next;
                l2 = l2.next;
            }
            current.next = new ListNode(l2.val);
        }

        if (l1 != null && l2 == null) {
            while (l1.next != null) {
                current.next = new ListNode(l1.val);
                current = current.next;
                l1 = l1.next;
            }
            current.next = new ListNode(l1.val);
        }

        return root;
    }

    public static void main(String[] args) {
        ListNode listNode1 = null;

        ListNode listNode2 = new ListNode(0);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode rs = mergeTwoSortedLists.mergeTwoLists(listNode1, listNode2);
        System.out.println(rs);

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}




