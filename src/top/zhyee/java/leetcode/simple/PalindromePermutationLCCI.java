package top.zhyee.java.leetcode.simple;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutationLCCI {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.remove(s.charAt(i));
            } else {
                map.put(s.charAt(i), 0);
            }
        }
        return map.size() == s.length() % 2;
    }
}

