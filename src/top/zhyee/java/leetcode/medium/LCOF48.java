package top.zhyee.java.leetcode.medium;

import com.sun.tools.javac.util.Assert;

import java.util.HashSet;
import java.util.Set;

public class LCOF48 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            int j = i;
            while (j < s.length() && set.add(s.charAt(j))) {
                j++;
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
    
    public static void main(String[] args) {
        LCOF48 lcof48 = new LCOF48();
        Assert.check(lcof48.lengthOfLongestSubstring("abcabcbb") == 3);
        Assert.check(lcof48.lengthOfLongestSubstring("bbbbb") == 1);
        Assert.check(lcof48.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
