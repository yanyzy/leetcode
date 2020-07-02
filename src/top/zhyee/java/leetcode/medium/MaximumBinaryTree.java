package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode head = new TreeNode(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > head.val) {
                TreeNode newHead = new TreeNode(nums[i]);
                newHead.left = head;
                head = newHead;
                continue;
            }
            TreeNode temp = head;
            while (temp.right != null && nums[i] < temp.right.val) {
                temp = temp.right;
            }
            TreeNode newRight = new TreeNode(nums[i]);
            newRight.left = temp.right;
            temp.right = newRight;
        }
        return head;
    }
    
    public static void main(String[] args) {
        System.out.println(new MaximumBinaryTree().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
    }
}
