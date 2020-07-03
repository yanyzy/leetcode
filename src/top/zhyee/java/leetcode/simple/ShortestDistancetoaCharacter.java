package top.zhyee.java.leetcode.simple;

import java.util.ArrayList;
import java.util.List;

public class ShortestDistancetoaCharacter {
    
    public int[] shortestToChar(String S, char C) {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                a.add(i);
            }
        }
        
        int[] res = new int[S.length()];
        for (int i = 0; i < S.length(); i++) {
            int min = Integer.MAX_VALUE;
            for (Integer integer : a) {
                min = Math.min(min, Math.abs(i - integer));
            }
            res[i] = min;
        }
        return res;
    }
    
}
