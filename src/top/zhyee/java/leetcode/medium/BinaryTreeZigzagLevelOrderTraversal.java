package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 103. 二叉树的锯齿形层次遍历
 * <p>
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层次遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    /**
     * 使用一个标记，记下当前应该从左往右还是从右往左
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        return zigzagLevelOrder(lists, Collections.singletonList(root), true);
    }

    private List<List<Integer>> zigzagLevelOrder(List<List<Integer>> lists, List<TreeNode> children, boolean isLeft) {
        if (children.size() == 0) {
            return lists;
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        for (TreeNode t : children) {
            if (t.left != null) {
                treeNodes.add(t.left);
            }
            if (t.right != null) {
                treeNodes.add(t.right);
            }
            if (isLeft) {
                integers.add(t.val);
            } else {
                integers.add(0, t.val);
            }
        }

        lists.add(integers);
        return zigzagLevelOrder(lists, treeNodes, !isLeft);
    }
}
