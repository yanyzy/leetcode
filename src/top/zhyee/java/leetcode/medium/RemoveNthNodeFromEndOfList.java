package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.ListNode;

/**
 * 19. 删除链表的倒数第N个节点
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthNodeFromEndOfList {
    
    private int n = 0;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 1 && head.next == null) {
            return null;
        }
        this.n = n;
        return remove(null, head);
    }
    
    private ListNode remove(ListNode pre, ListNode node) {
        if (node.next == null) {
            n--;
            if (n == 0) {
                n--;
                if(pre != null){
                    pre.next = null;
                    return pre;
                }else {
                    return null;
                }
            }
            return node;
        }
        ListNode ret = remove(node, node.next);
        if (n > 0) {
            n--;
        }
        if (n == 0) {
            n--;
            if(pre != null){
                pre.next = ret;
                return pre;
            }else {
                return ret;
            }
        }
        return node;
    }
    
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(3);
//        listNode.next.next.next = new ListNode(4);
//        listNode.next.next.next.next = new ListNode(5);
        
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        System.out.println(removeNthNodeFromEndOfList.removeNthFromEnd(listNode, 2));
    }
}
