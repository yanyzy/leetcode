package top.zhyee.java.leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        
        for (int j = 1; j < dp.length; j++) {
            for (int coin : coins) {
                if (j >= coin) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
    
    public static void main(String[] args) {
        System.out.println(new CoinChange().coinChange(new int[]{2}, 3));
    }
}
