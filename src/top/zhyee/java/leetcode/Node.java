package top.zhyee.java.leetcode;

import java.util.List;

/**
 * @author zhyee
 * @date 2019/5/8 下午5:03
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
