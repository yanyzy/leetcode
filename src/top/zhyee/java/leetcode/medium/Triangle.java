package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
        dp[1][0] = triangle.get(1).get(0) + dp[0][0];
        dp[1][1] = triangle.get(1).get(1) + dp[0][0];
        
        for (int i = 2; i < triangle.size(); i++) {
            int j = 0;
            while (j < triangle.get(i).size()) {
                if (j == 0) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(triangle.get(i).get(j) + dp[i - 1][j], triangle.get(i).get(j) + dp[i - 1][j - 1]);
                }
                j++;
            }
        }
        int l = triangle.size() - 1;
        int res = dp[l][0];
        for (int i = 1; i < dp[l].length; i++) {
            res = Math.min(res, dp[l][i]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Collections.singletonList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Triangle().minimumTotal(list));
    }
}
