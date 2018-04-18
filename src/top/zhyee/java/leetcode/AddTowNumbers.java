package top.zhyee.java.leetcode;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTowNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = null;

        List<Integer> l1list = travelLinkedList(l1);
        List<Integer> l2list = travelLinkedList(l2);

        int length = l1list.size() > l2list.size() ? l1list.size() : l2list.size();

        List<Integer> l3list = new ArrayList<>();

        int tens = 0;
        for (int i = 0; i < length; i++) {
            int l1num = 0;
            int l2num = 0;
//            if((l1list.size() - 1 - i)>=0){
//                l1num = l1list.get(l1list.size() - 1 - i);
//            }
//            if((l2list.size() - 1 - i)>=0) {
//                l2num = l2list.get(l2list.size() - 1 - i);
//            }
            if(i<l1list.size()){
                l1num= l1list.get(i);
            }
            if(i<l2list.size()){
                l2num = l2list.get(i);
            }
            int sum = l1num + l2num;

            if (tens != 0) {
                sum = sum + tens;
                tens = 0;
            }

            if (sum >= 10) {
                tens = sum / 10;
                sum = sum - 10;
            }
            //l3list.add(sum);

            if (l3 == null) {
                l3 = new ListNode(sum);
            }
            else{
                addNode(l3,new ListNode(sum));
            }

        }

        if(tens !=0){
            addNode(l3,new ListNode(1));
        }


        return l3;
    }

    private static void addNode(ListNode oldNode,ListNode newNode){
        if(oldNode.next == null){
            oldNode.next = newNode;
        }else{
            addNode(oldNode.next,newNode);
        }
    }

    private static List<Integer> travelLinkedList(ListNode node) {
        List<Integer> vals = new ArrayList<>();
        while (node != null) {
            vals.add(node.val);
            node = node.next;
        }

        return vals;
    }


    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(8);
        //ListNode l13 = new ListNode(3);
        l11.next = l12;

        ListNode l21 = new ListNode(0);
//        ListNode l22 = new ListNode(6);
//        ListNode l23 = new ListNode(4);
//        l21.next = l22;
//        l22.next = l23;


        System.out.println(new AddTowNumbers().addTwoNumbers(l11, l21).toString());
    }
}
