package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class KthSmallestElementInABST {
    
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        int n = count(root.left);
        if (n == k - 1) {
            return root.val;
        } else if (n > k - 1) {
            return kthSmallest(root.left, k);
        }
        return kthSmallest(root.right, k - n - 1);
    }
  
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
    
    public static void main(String[] args) {
        KthSmallestElementInABST kthSmallestElementInABST = new KthSmallestElementInABST();
        TreeNode treeNode1 = new TreeNode(3);
        treeNode1.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(2);
        treeNode1.right = new TreeNode(4);
        System.out.println(kthSmallestElementInABST.kthSmallest(treeNode1, 1));
        
        TreeNode treeNode2 = new TreeNode(5);
        treeNode2.left = new TreeNode(3);
        treeNode2.left.right = new TreeNode(4);
        treeNode2.left.left = new TreeNode(2);
        treeNode2.left.left.left = new TreeNode(1);
        treeNode2.right = new TreeNode(6);
        System.out.println(kthSmallestElementInABST.kthSmallest(treeNode2, 3));
        
        TreeNode treeNode3 = new TreeNode(1);
        treeNode3.right = new TreeNode(2);
        System.out.println(kthSmallestElementInABST.kthSmallest(treeNode3, 2));
    }
}
