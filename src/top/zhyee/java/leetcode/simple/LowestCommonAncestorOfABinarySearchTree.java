package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.TreeNode;

/**
 * @author zhyee
 * @date 2019/5/22 下午4:18
 */
//todo 未通过

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 */

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val) || (p.val == root.val) || q.val == root.val) {
            return root;
        }

        if (p.val < root.val && q.val < root.val) {
            //在左子树中
            TreeNode temp = root.left;
            while (temp != null) {
                if (temp.val == p.val || temp.val == q.val) {
                    return temp.val == p.val ? p : q;
                } else if (temp.val < Math.min(p.val, q.val)) {
                    temp = temp.right;
                } else if (Math.min(p.val, q.val) < temp.val && temp.val < Math.max(p.val, q.val)) {
                    return temp;
                } else {
                    temp = temp.left;
                }
            }

        } else {
            //在右子树中

            TreeNode temp = root.right;
            while (temp != null) {
                if (temp.val == p.val || temp.val == q.val) {
                    return temp.val == p.val ? p : q;
                } else if (temp.val > Math.max(p.val, q.val)) {
                    temp = temp.right;
                } else if (Math.min(p.val, q.val) < temp.val && temp.val < Math.max(p.val, q.val)) {
                    return temp;
                } else {
                    temp = temp.right;
                }
            }

        }

        return null;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        LowestCommonAncestorOfABinarySearchTree lowestCommonAncestorOfABinarySearchTree = new LowestCommonAncestorOfABinarySearchTree();
        System.out.println(lowestCommonAncestorOfABinarySearchTree.lowestCommonAncestor(root, root.left.right.left, root.left.right.right).val);
    }
}
