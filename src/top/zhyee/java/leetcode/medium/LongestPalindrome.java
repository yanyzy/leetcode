package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = map.values()
                .stream()
                .map(v -> {
                    if (v % 2 == 0) {
                        return v;
                    } else if (v > 1) {
                        return v - 1;
                    }
                    return 0;
                })
                .mapToInt(Integer::intValue)
                .sum();
        if (map.values().stream().anyMatch(v -> v % 2 == 1)) {
            count++;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("a"));
    }
}
