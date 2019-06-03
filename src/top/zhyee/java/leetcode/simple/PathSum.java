package top.zhyee.java.leetcode.simple;

import com.sun.tools.javac.util.Assert;
import top.zhyee.java.leetcode.TreeNode;

/**
 * @author zhyee
 * @date 2019/6/3 上午10:13
 */


/**
 * 112. 路径总和
 *
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            return true;
        } else {
            return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
        }
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode treeNode = new TreeNode(0);
        treeNode.right = new TreeNode(1);
        treeNode.left = new TreeNode(1);
        Assert.check(pathSum.hasPathSum(treeNode, 1));

        TreeNode treeNode1 = new TreeNode(1);
        treeNode1.left = new TreeNode(-2);
        treeNode1.left.left = new TreeNode(1);
        treeNode1.left.right = new TreeNode(3);
        treeNode1.left.left.left = new TreeNode(-1);
        treeNode1.right = new TreeNode(-3);
        treeNode1.right.left = new TreeNode(-2);
        Assert.check(pathSum.hasPathSum(treeNode1, -1));
    }
}
