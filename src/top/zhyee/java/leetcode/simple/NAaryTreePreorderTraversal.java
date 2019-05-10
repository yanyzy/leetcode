package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/5/10 下午2:48
 */

/**
 * 589. N叉树的前序遍历
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :

 * 返回其前序遍历: [1,3,5,6,2,4]。
 *
 *
 */
public class NAaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> integers = new ArrayList<>();
        integers.add(root.val);
        preorder(root.children, integers);
        return integers;
    }

    private void preorder(List<Node> nodes, List<Integer> list) {
        for (Node n :
                nodes) {
            list.add(n.val);
            if (n.children.size() != 0) {
                preorder(n.children, list);
            }
        }
    }


}
