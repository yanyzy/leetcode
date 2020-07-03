package top.zhyee.java.leetcode.medium;

import java.util.Stack;

public class ReverseWordsinaString {
    
    public String reverseWords(String s) {
        Stack<String> strings = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int stopIndex = i;
            while (stopIndex < s.length() && s.charAt(stopIndex) != ' ') {
                stopIndex++;
            }
            if (i != stopIndex) {
                String temp = s.substring(i, stopIndex);
                strings.push(temp);
            }
            i = stopIndex;
        }
        if(strings.empty()){
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!strings.empty()) {
            stringBuilder.append(strings.pop());
            stringBuilder.append(" ");
        }
        String s1 = stringBuilder.toString();
        return s1.substring(0, s1.length() - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new ReverseWordsinaString().reverseWords(""));
    }
}
