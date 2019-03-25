package top.zhyee.java.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/3/24 下午10:28
 */
public class SortList {

    public ListNode sortList(ListNode head) {
        return sort(head);
    }


    private ListNode sort(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return listNode;
        }

        if (listNode.next.next == null) {
            if (listNode.val > listNode.next.val) {
                int temp = listNode.val;
                listNode.val = listNode.next.val;
                listNode.next.val = temp;
            }
            return listNode;
        }

        List<ListNode> listNodes = spite(listNode);
        return sortList(listNodes.get(0), listNodes.get(1), listNodes.get(2));
    }

    private ListNode sortList(ListNode left, ListNode mid, ListNode right) {
        return merge(sort(left), mid, sort(right));
    }


    private ListNode merge(ListNode left, ListNode mid, ListNode right) {
        ListNode root;
        if (left != null) {
            root = left;
            while (left.next != null) {
                left = left.next;
            }
            left.next = mid;

        } else {
            root = mid;
        }

        while (mid.next != null) {
            mid = mid.next;
        }
        mid.next = right;
        return root;
    }


    /**
     * 分割链表
     * 以第一个节点为中值，比它小的排在左边，比它大的排在右边
     */
    private List<ListNode> spite(ListNode listNode) {
        ListNode midNode = listNode;
        int midVal = listNode.val;
        listNode = listNode.next;

        ListNode rightHead = null;
        ListNode leftHead = null;
        ListNode leftCurrent = null;
        ListNode rightCurrent = null;
        ListNode midCurrent = midNode;

        while (listNode != null) {
            if (midVal > listNode.val) {
                if (leftHead == null) {
                    leftHead = listNode;
                    leftCurrent = leftHead;
                } else {
                    leftCurrent.next = listNode;
                    leftCurrent = leftCurrent.next;
                }
            } else if (midVal < listNode.val) {
                if (rightHead == null) {
                    rightHead = listNode;
                    rightCurrent = rightHead;
                } else {
                    rightCurrent.next = listNode;
                    rightCurrent = rightCurrent.next;
                }
            } else {
                midCurrent.next = listNode;
                midCurrent = midCurrent.next;
            }
            listNode = listNode.next;
        }

        if (rightCurrent != null) {
            rightCurrent.next = null;
        }
        if (leftCurrent != null) {
            leftCurrent.next = null;
        }
        midCurrent.next = null;
        return Arrays.asList(leftHead, midNode, rightHead);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(1);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(0);
        listNode1.next.next.next.next.next = new ListNode(-1);
        SortList sortList = new SortList();
        System.out.println(sortList.sortList(listNode1));
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
