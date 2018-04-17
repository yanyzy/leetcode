package top.zhyee.java.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {

            char nowChar = s.charAt(i);

            if (isLeftCouple(nowChar)) {
                stack.push(nowChar);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            char preChar = stack.peek();

            if (!isCouple(preChar, nowChar)) {
                return false;
            }
            stack.pop();
        }
        return stack.empty();
    }

    private static boolean isLeftCouple(char a) {
        return a == '(' || a == '{' || a == '[';
    }

    private static boolean isCouple(char a, char b) {
        switch (a) {
            case '(':
                return b == ')';
            case '[':
                return b == ']';
            case '{':
                return b == '}';
            default:
                return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new ValidParentheses().isValid("){"));
    }
}
