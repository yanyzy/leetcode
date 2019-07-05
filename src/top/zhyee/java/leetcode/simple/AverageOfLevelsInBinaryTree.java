package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.TreeNode;

import java.util.*;


/**
 * 637. 二叉树的层平均值
 * <p>
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出: [3, 14.5, 11]
 * 解释:
 * 第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
 * 注意：
 * <p>
 * 节点值的范围在32位有符号整数范围内。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Map<Integer, Integer> levelMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        if (root == null) {
            return null;
        }
        levelMap.put(0, 1);
        queue.add(root.val);
        add(queue, levelMap, Collections.singletonList(root));
        List<Double> list = new ArrayList<>();

        levelMap.forEach((k, v) -> {
            double count = 0;
            int sum = v;
            while (v > 0) {
                count = count + queue.poll();
                v--;
            }
            list.add(count / sum);
        });
        return list;
    }

    private void add(Queue<Integer> queue, Map<Integer, Integer> levelMap, List<TreeNode> list) {
        if (list.size() == 0) {
            return;
        }
        List<TreeNode> children = new ArrayList<>();
        int nodeCount = 0;
        for (TreeNode treeNode : list) {
            if (treeNode.left != null) {
                children.add(treeNode.left);
                queue.add(treeNode.left.val);
                nodeCount++;
            }
            if (treeNode.right != null) {
                children.add(treeNode.right);
                queue.add(treeNode.right.val);
                nodeCount++;
            }
        }
        if (nodeCount != 0) {
            levelMap.put(levelMap.size() + 1, nodeCount);
        }
        add(queue, levelMap, children);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = new TreeNode(15);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(20);

        System.out.println(new AverageOfLevelsInBinaryTree().averageOfLevels(treeNode));

    }
}
