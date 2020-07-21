package top.zhyee.java.leetcode.medium;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UniqueBinarySearchTreesII {
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        return generateTreesByList(1, n);
    }
    
    
    private List<TreeNode> generateTreesByList(int from, int to) {
        if (from > to) {
            return Collections.singletonList(null);
        }
        if (from == to) {
            return Collections.singletonList(new TreeNode(to));
        }
        List<TreeNode> treeNodes = new ArrayList<>();
        for (int i = from; i <= to; i++) {
            List<TreeNode> left = generateTreesByList(from, i - 1);
            List<TreeNode> right = generateTreesByList(i + 1, to);
            
            for (int j = 0; j < left.size(); j++) {
                for (int k = 0; k < right.size(); k++) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = left.get(j);
                    treeNode.right = right.get(k);
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;
    }
    
    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTreesII().generateTrees(3));
    }
}
