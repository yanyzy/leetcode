package top.zhyee.java.leetcode.simple;

import top.zhyee.java.leetcode.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/5/8 下午5:03
 */


/**
 * 429. N叉树的层序遍历
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 *
 * 例如，给定一个 3叉树 :
 *
 *
 *
 *
 *
 *
 *
 * 返回其层序遍历:
 *
 * [
 *      [1],
 *      [3,2,4],
 *      [5,6]
 * ]
 *
 *
 * 说明:
 *
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 */
public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(Collections.singletonList(root.val));
        if (root.children.size() != 0) {
            order(root.children, lists);
        }
        return lists;
    }

    private List<Integer> order(List<Node> roots, List<List<Integer>> lists) {
        List<Integer> list = new ArrayList<>();
        List<Node> nodes = new ArrayList<>();
        for (Node n : roots) {
            list.add(n.val);
            if (n.children != null) {
                nodes.addAll(n.children);
            }
        }
        lists.add(list);
        if (nodes.size() != 0) {
            order(nodes, lists);
        }
        return list;
    }

    public static void main(String[] args) {
        NAryTreeLevelOrderTraversal nAryTreeLevelOrderTraversal = new NAryTreeLevelOrderTraversal();
        Node root = new Node();
        root.val = 44;
        root.children = new ArrayList<>();

//        Node root2 = new Node();
//        root2.val = 3;
//
//        Node root3 = new Node();
//        root3.val = 2;
//
//        Node root4 = new Node();
//        root4.val = 4;
//
//        root.children = Arrays.asList(root2, root3, root4);
//
//        Node root5 = new Node();
//        root5.val = 5;
//
//        Node root6 = new Node();
//        root6.val = 6;
//
//        root2.children = Arrays.asList(root5, root6);

        System.out.println(nAryTreeLevelOrderTraversal.levelOrder(root));
    }
}
