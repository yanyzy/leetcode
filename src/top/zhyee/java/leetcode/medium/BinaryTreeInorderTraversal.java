package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        return inorderTraversal(root, integers);
    }
    
    public List<Integer> inorderTraversal(TreeNode root, List<Integer> integers) {
        if (root == null) {
            return integers;
        }
        if (root.left != null) {
            inorderTraversal(root.left, integers);
        }
        integers.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, integers);
        }
        return integers;
    }
    
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal(treeNode));
    }
}
