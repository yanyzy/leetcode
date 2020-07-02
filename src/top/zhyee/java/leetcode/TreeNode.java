package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/28 下午2:50
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
    
    @Override
    public String toString() {
        return toString(this);
    }
    
    protected String toString(TreeNode node) {
        if (node == null) {
            return "";
        }
        return node.val + "(" + toString(node.left) + ", " +
                toString(node.right) + ")";
    }
}
