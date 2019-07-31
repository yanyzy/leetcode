package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


//todo
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(Collections.singletonList(root));
    }

    private boolean isSymmetric(List<TreeNode> list) {
        List<TreeNode> list1 = new ArrayList<>();

        for (TreeNode n : list) {
            if (n != null) {
                list1.add(n.left);
                list1.add(n.right);
            }
        }

        if (list1.size() == 0) {
            return true;
        }

        int size = list1.size() / 2;
        int j = list1.size() - 1;
        for (int i = 0; i < size; i++) {
            if (list1.get(i).val != list1.get(j).val) {
                return false;
            }
            j--;
        }
        return isSymmetric(list1);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(2);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        treeNode.right.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(3);

        System.out.println(new SymmetricTree().isSymmetric(treeNode));
    }
}
