package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalIterator {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integers = new ArrayList<>();
        if (root == null) {
            return integers;
        }
        Stack<TreeNode> treeNodes = new Stack<>();
        return inorderTraversal(root, treeNodes, integers);
    }
    
    public List<Integer> inorderTraversal(TreeNode root, Stack<TreeNode> treeNodes, List<Integer> integers) {
        while (true) {
            while (root != null) {
                treeNodes.push(root);
                root = root.left;
            }
            if (treeNodes.isEmpty()) {
                return integers;
            }
            TreeNode node = treeNodes.pop();
            integers.add(node.val);
            root = node.right;
        }
    }
    
    
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        treeNode.right.left = new TreeNode(3);
        System.out.println(new BinaryTreeInorderTraversalIterator().inorderTraversal(treeNode));
        
        TreeNode treeNode1 = new TreeNode(2);
        treeNode1.left = new TreeNode(3);
        treeNode1.right = null;
        treeNode1.left.left = new TreeNode(1);
        System.out.println(new BinaryTreeInorderTraversalIterator().inorderTraversal(treeNode1));
    }
}
