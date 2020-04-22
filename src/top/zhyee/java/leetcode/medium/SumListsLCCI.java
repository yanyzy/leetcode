package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 面试题 02.05. 链表求和
 * <p>
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * <p>
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * <p>
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * <p>
 * 示例：
 * <p>
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumListsLCCI {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int needAdd = 0;
        List<Integer> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            int i = l1.val + l2.val + needAdd;
            needAdd = 0;
            if (i >= 10) {
                needAdd = i / 10;
                i = i % 10;
            }
            list.add(i);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null) {
            while (l2 != null) {
                int i = l2.val + needAdd;
                needAdd = 0;
                if (i >= 10) {
                    needAdd = i / 10;
                    i = i % 10;
                }
                list.add(i);
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                int i = l1.val + needAdd;
                needAdd = 0;
                if (i >= 10) {
                    needAdd = i / 10;
                    i = i % 10;
                }
                list.add(i);
                l1 = l1.next;
            }
        }
        if (needAdd != 0) {
            list.add(needAdd);
        }
        ListNode newHead = new ListNode(0);
        ListNode node = newHead;
        for (Integer integer : list) {
            node.next = new ListNode(integer);
            node = node.next;
        }
        return newHead.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(6);
        
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(2);
        
        System.out.println(new SumListsLCCI().addTwoNumbers(l1, l2));
    }
}
