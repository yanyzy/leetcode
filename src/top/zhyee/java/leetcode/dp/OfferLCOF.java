package top.zhyee.java.leetcode.dp;

public class OfferLCOF {
    public int numWays(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n] % 1000000007;
    }
}
