package top.zhyee.java.leetcode.simple;

import com.sun.tools.javac.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutationLCCI {
    
    public boolean CheckPermutation(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        
        for (int i = 0; i < s2.length(); i++) {
            if (map.get(s2.charAt(i)) == null || map.get(s2.charAt(i)) == 0) {
                return false;
            }
            if (map.get(s2.charAt(i)) == 1) {
                map.remove(s2.charAt(i));
                continue;
            }
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        }
        
        return map.size()==0;
    }
    
    public static void main(String[] args) {
        CheckPermutationLCCI checkPermutationLCCI = new CheckPermutationLCCI();
        Assert.check(checkPermutationLCCI.CheckPermutation("bkhfhqlayvlhdqmxvnkqvtkojouugfsnwmyoywkilsnubnkvhdbrltuxvoblurpfinpigajttcvkcxlylblcaocsjmwdvwepvnfr", "mtycyvobjldulmhsuqvtrhqnisjkuxhvaxqkvpbllnkvvakxjbolefpyrtiivvwctunasbbocldflkcknmwgofngorduwlwhyfnp"));
    }
}
