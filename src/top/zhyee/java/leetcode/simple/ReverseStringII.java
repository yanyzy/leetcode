package top.zhyee.java.leetcode.simple;

import java.util.Stack;

/**
 * @author zhyee
 * @date 2019/4/24 下午3:37
 */


/**
 * 541. 反转字符串 II
 *
 * 给定一个字符串和一个整数 k，你需要对从字符串开头算起的每个 2k 个字符的前k个字符进行反转。如果剩余少于 k 个字符，则将剩余的所有全部反转。如果有小于 2k 但大于或等于 k 个字符，则反转前 k 个字符，并将剩余的字符保持原样。
 *
 * 示例:
 *
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * 要求:
 *
 * 该字符串只包含小写的英文字母。
 * 给定字符串的长度和 k 在[1, 10000]范围内。
 */
public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int length = s.length();
        for (int i = 0; i < length; i = i + 2 * k) {
            if (i + 2 * k < length) {
                s = reverse(s, i, i + k - 1);
            } else if (i + k < length) {
                s = reverse(s, i, i + k - 1);
            } else {
                s = reverse(s, i, s.length() - 1);
            }
        }
        return s;
    }

    private String reverse(String s, int start, int end) {
        StringBuilder stringBuilder = new StringBuilder();
        String s1 = s.substring(0, start);
        stringBuilder.append(s1);
        Stack<Character> stack = new Stack<>();
        while (start <= end) {
            stack.push(s.charAt(start));
            start++;
        }

        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }
        String s2 = s.substring(end + 1, s.length());
        stringBuilder.append(s2);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseStringII reverseStringII = new ReverseStringII();
        String s = reverseStringII.reverseStr("abcdefg", 2);
        System.out.println(s);
    }
}
