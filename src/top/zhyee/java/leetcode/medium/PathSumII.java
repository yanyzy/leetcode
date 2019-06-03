package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/6/3 上午11:39
 */

/**
 * 113. 路径总和 II
 *
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
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
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 */
public class PathSumII {

    private List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList<>();
        pathSum(root, sum, list);
        return lists;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> list) {
        if (root == null) {
            return;
        }
        List<Integer> newlist = new ArrayList<>();
        newlist.addAll(list);
        sum = sum - root.val;
        if (sum == 0 && root.left == null && root.right == null) {
            newlist.add(root.val);
            lists.add(newlist);
        } else {
            newlist.add(root.val);
            pathSum(root.left, sum, newlist);
            pathSum(root.right, sum, newlist);
        }
    }
}
