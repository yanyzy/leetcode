package top.zhyee.java.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/3/24 下午10:28
 */
//todo 未通过
public class SortList {

    public ListNode sortList(ListNode head) {
        return sort(head);
    }


    private ListNode sort(ListNode listNode) {
        if (listNode == null) {
            return null;
        }
        if (listNode.next == null) {
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
        return sortList(listNodes.get(0), listNodes.get(1));
    }

    private ListNode sortList(ListNode left, ListNode right) {
        return merge(sort(left), sort(right));
    }


    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        ListNode root;
        if (left.val < right.val) {
            root = left;
            left = left.next;
        } else {
            root = right;
            right = right.next;
        }

        ListNode current = root;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        while (left != null) {
            current.next = left;
            left = left.next;
            current = current.next;
        }

        while (right != null) {
            current.next = right;
            right = right.next;
            current = current.next;
        }


        return root;
    }


    /**
     * 分割链表
     * 以第一个节点为中值，比它小的排在左边，比它大的排在右边
     */
    private List<ListNode> spite(ListNode listNode) {
        ListNode rightHead = new ListNode(listNode.val);
        ListNode leftHead = null;
        ListNode leftCurrent = null;
        ListNode rightCurrent = rightHead;
        int mid = listNode.val;
        listNode = listNode.next;

        while (listNode.next != null) {
            if (mid > listNode.val) {
                if (leftHead == null) {
                    leftHead = new ListNode(listNode.val);
                    leftCurrent = leftHead;
                } else {
                    leftCurrent.next = new ListNode(listNode.val);
                    leftCurrent = leftCurrent.next;
                }
            } else {
                rightCurrent.next = new ListNode(listNode.val);
                rightCurrent = rightCurrent.next;

            }
            listNode = listNode.next;
        }

        if (mid > listNode.val) {
            if (leftHead == null) {
                leftHead = new ListNode(listNode.val);
            } else {
                leftCurrent.next = new ListNode(listNode.val);
            }
        } else {
            rightCurrent.next = new ListNode(listNode.val);
        }

        if (leftHead == null) {
            leftHead = new ListNode(rightHead.val);
            rightHead = rightHead.next;
        }
        return Arrays.asList(leftHead, rightHead);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        listNode1.next = new ListNode(5);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        listNode1.next.next.next.next = new ListNode(0);
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
