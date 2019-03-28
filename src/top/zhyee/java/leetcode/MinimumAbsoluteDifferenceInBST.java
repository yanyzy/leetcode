package top.zhyee.java.leetcode;


/**
 * @author zhyee
 * @date 2019/3/28 下午2:49
 */

/**
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给定一个所有节点为非负值的二叉搜索树，求树中任意两节点的差的绝对值的最小值。
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * 输出:
 * 1
 * <p>
 * 解释:
 * 最小绝对差为1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 * 注意: 树中至少有2个节点。
 */
public class MinimumAbsoluteDifferenceInBST {

    public int getMinimumDifference(TreeNode root) {

        return getMinimumDifference(root, Integer.MAX_VALUE);
    }

    private int getMinimumDifference(TreeNode root, int n) {

        int m;

        if (root.left == null && root.right == null) {
            return n;
        }
        if (root.left == null) {
            m = getMinimumDifference(root.right, getRightMin(root.right) - root.val);
        } else if (root.right == null) {
            m = getMinimumDifference(root.left, root.val - getLeftMax(root.left));
        } else {
            int y = getMinimumDifference(root.right, getRightMin(root.right) - root.val);
            int x = getMinimumDifference(root.left, root.val - getLeftMax(root.left));
            m = y < x ? y : x;
        }
        return n < m ? n : m;
    }

    private int getLeftMax(TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.val;
    }

    private int getRightMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }

    public static void main(String[] args) {

    }
}
