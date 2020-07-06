package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KClosestPointstoOrigin {
    public int[][] kClosest(int[][] points, int K) {
        Map<int[], Double> map = new HashMap<>();
        
        for (int[] ints : points) {
            double res = Math.pow(ints[0], 2) + Math.pow(ints[1], 2);
            map.put(ints, res);
        }
        
        List<int[]> collect = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        
        int[][] res = new int[K][];
        int i = 0;
        while (K > 0) {
            res[i] = collect.get(i);
            i++;
            K--;
        }
        return res;
    }
}
