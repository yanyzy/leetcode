package top.zhyee.java.leetcode.medium;


/**
 * 392. 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSubsequence {

    /**
     * 双指针法，判断为真的条件是，s 指针已经走到最后，并且此时两个指针所在位置的值相等
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int sIndex = 0;
        int tIndex = 0;

        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                if (sIndex == s.length() - 1) {
                    return true;
                }
                sIndex++;
                tIndex++;
            } else {
                tIndex++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence("acb", "ahbgdc"));
    }
}
