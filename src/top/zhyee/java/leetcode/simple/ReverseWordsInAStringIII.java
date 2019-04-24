package top.zhyee.java.leetcode.simple;

import java.util.Stack;

/**
 * @author zhyee
 * @date 2019/4/24 下午5:03
 */


/**
 * 557. 反转字符串中的单词 III
 *
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例 1:
 *
 * 输入: "Let's take LeetCode contest"
 * 输出: "s'teL ekat edoCteeL tsetnoc"
 * 注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                while (!stack.empty()) {
                    stringBuilder.append(stack.pop());
                }
                stringBuilder.append(" ");
            } else {
                stack.push(s.charAt(i));
            }
        }

        while (!stack.empty()) {
            stringBuilder.append(stack.pop());
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReverseWordsInAStringIII reverseWordsInAStringIII = new ReverseWordsInAStringIII();
        System.out.println(reverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"));
    }
}
