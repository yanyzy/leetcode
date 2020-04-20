package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LCOF {

    //用map储存复制节点
    public Node copyRandomListHash(Node head) {
        if (head == null) {
            return head;
        }

        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        Node temp2 = head;
        while (temp2 != null) {
            map.get(temp2).next = map.get(temp2.next);
            map.get(temp2).random = map.get(temp2.random);
            temp2 = temp2.next;
        }
        return map.get(head);
    }
    
    //原地复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        //复制节点
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            copyNode.next = cur.next;
            cur.next = copyNode;
            cur = cur.next.next;
        }
        
        //处理复制节点的 random 节点
        Node cur1 = head;
        while (cur1 != null && cur1.next != null) {
            if (cur1.random != null) {
                cur1.next.random = cur1.random.next;
            }
            cur1 = cur1.next.next;
        }
    
        Node newHead = head.next;
        for (Node node = head, temp = null; node != null && node.next != null;) {
            temp = node.next;
            node.next = temp.next;
            node = temp;
        }
        return newHead;
    }
    
    static class Node {
        int val;
        Node next;
        Node random;
        
        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;
        System.out.println(new LCOF().copyRandomList(node1));
    }
}
