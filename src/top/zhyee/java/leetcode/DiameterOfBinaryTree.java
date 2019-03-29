package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/29 下午2:50
 */

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 543. 二叉树的直径
 * <p>
 * 给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。这条路径可能穿过根结点。
 * <p>
 * 示例 :
 * 给定二叉树
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * 返回 3, 它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]。
 * <p>
 * 注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class DiameterOfBinaryTree {

    //todo 543
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getLen(root.left, 0) + getLen(root.right, 0);
    }

    private int getLen(TreeNode node, int n) {

        if (node == null) {
            return n;
        }
        if (node.left == null && node.right == null) {
            return n + 1;
        }
        if (node.left == null) {
            return getLen(node.right, n + 1);
        }
        if (node.right == null) {
            return getLen(node.left, n + 1);
        }
        int left = getLen(node.left, n + 1);
        int right = getLen(node.right, n + 1);

        return left > right ? left : right;

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(-7);
        treeNode.right = new TreeNode(-3);
        treeNode.right.left = new TreeNode(-9);
        treeNode.right.right = new TreeNode(-3);
        treeNode.right.left.left = new TreeNode(9);

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(treeNode));
    }
}
