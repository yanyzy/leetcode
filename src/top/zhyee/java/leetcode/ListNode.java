package top.zhyee.java.leetcode;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author zhyee
 * 2018/10/11 下午4:37
 */
public class ListNode {
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
