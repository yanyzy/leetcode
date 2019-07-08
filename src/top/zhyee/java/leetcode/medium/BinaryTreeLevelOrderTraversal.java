package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * 102. 二叉树的层次遍历
 * <p>
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class BinaryTreeLevelOrderTraversal {

    /**
     * 需要两个 list
     * 一个放返回值，一个放当前节点的子节点
     * 然后递归调用，讲每一个子节点添加到 list 中
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        return add(lists, Collections.singletonList(root));
    }

    private List<List<Integer>> add(List<List<Integer>> lists, List<TreeNode> children) {
        if (children.size() == 0) {
            return lists;
        }
        List<TreeNode> list = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();

        for (TreeNode t : children) {
            integers.add(t.val);
            if (t.left != null) {
                list.add(t.left);
            }
            if (t.right != null) {
                list.add(t.right);
            }
        }
        if (integers.size() != 0) {
            lists.add(integers);
        }
        add(lists, list);
        return lists;
    }
}
