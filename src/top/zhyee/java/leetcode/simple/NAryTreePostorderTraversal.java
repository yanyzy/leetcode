package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @author zhyee
 * @date 2019/5/10 下午3:10
 */

/**
 * 590. N叉树的后序遍历
 * <p>
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 * <p>
 * 例如，给定一个 3叉树 :
 * <p>
 * 返回其后序遍历: [5,6,3,2,4,1].
 */
public class NAryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> integers = new ArrayList<>();
        postorder(root.children, integers);
        integers.add(root.val);
        return integers;
    }

    private void postorder(List<Node> nodes, List<Integer> list) {
        for (Node n :
                nodes) {
            if (n.children.size() != 0) {
                postorder(n.children, list);
            }
            list.add(n.val);
        }
    }
}
