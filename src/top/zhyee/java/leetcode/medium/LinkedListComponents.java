package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * <p>
 * 给定一个链表（链表结点包含一个整型值）的头结点 head。
 * <p>
 * 同时给定列表 G，该列表是上述链表中整型值的一个子集。
 * <p>
 * 返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * 输出: 2
 * 解释:
 * 链表中,0 和 1 是相连接的，且 G 中不包含 2，所以 [0, 1] 是 G 的一个组件，同理 [3] 也是一个组件，故返回 2。
 * 示例 2：
 * <p>
 * 输入:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * 输出: 2
 * 解释:
 * 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-components
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListComponents {
    
    public int numComponents(ListNode head, int[] G) {
        boolean lastStatus = false;
        Set<Integer> g = new HashSet();
        for (int i = 0; i < G.length; i++) {
            g.add(G[i]);
        }
        int n = 0;
        while (head != null) {
            boolean thisStatus = true;
            if (!g.contains(head.val)) {
                thisStatus = false;
            }
            if (thisStatus != lastStatus && thisStatus) {
                n++;
            }
            lastStatus = thisStatus;
            head = head.next;
        }
        return n;
    }
    
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(3);
//        node.next.next.next.next = new ListNode(4);
        int[] G = new int[]{0, 1, 3};
        System.out.println(new LinkedListComponents().numComponents(node, G));
    }
}
