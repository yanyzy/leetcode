package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.simple.HappyNumber;

public class MyLinkedList {
    
    private MyNode head;
    
    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        head = null;
    }
    
    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        MyNode node = head;
        while (index > 0 && node != null) {
            index--;
            node = node.next;
        }
        if (index == 0 && node != null) {
            return node.val;
        } else {
            return -1;
        }
    }
    
    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        MyNode node = new MyNode(val);
        node.next = head;
        head = node;
    }
    
    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        MyNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new MyNode(val);
    }
    
    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        MyNode node = head;
        MyNode pre = null;
        while (index > 0 && node != null) {
            index--;
            pre = node;
            node = node.next;
        }
        if (index == 0) {
            MyNode newNode = new MyNode(val);
            if (pre != null) {
                pre.next = newNode;
            } else {
                head = newNode;
            }
            newNode.next = node;
        }
    }
    
    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        MyNode node = head;
        MyNode pre = null;
        while (index > 0 && node != null) {
            index--;
            pre = node;
            node = node.next;
        }
        if (index == 0) {
            if (node == null) {
                return;
            }
            if (pre == null) {
                head = node.next;
            } else {
                pre.next = node.next;
            }
        }
    }
    
    class MyNode {
        int val;
        MyNode next;
        
        MyNode(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args) {
        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(5);
        obj.addAtHead(4);
        obj.addAtHead(3);
        obj.addAtHead(2);
        obj.addAtHead(1);
        obj.addAtTail(6);
        obj.addAtIndex(6, 7);
        obj.deleteAtIndex(6);
        int param_1 = obj.get(4);
        System.out.println(param_1);
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
