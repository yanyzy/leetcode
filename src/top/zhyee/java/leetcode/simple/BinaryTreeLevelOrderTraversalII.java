package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 107. 二叉树的层次遍历 II
 * <p>
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        return levelOrderBottom(lists, Collections.singletonList(root));
    }

    private List<List<Integer>> levelOrderBottom(List<List<Integer>> lists, List<TreeNode> children) {
        if (children.size() == 0) {
            return lists;
        }

        List<TreeNode> treeNodes = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        for (TreeNode t : children) {
            integers.add(t.val);
            if (t.left != null) {
                treeNodes.add(t.left);
            }
            if (t.right != null) {
                treeNodes.add(t.right);
            }
        }
        levelOrderBottom(lists, treeNodes);
        lists.add(integers);
        return lists;
    }
}
