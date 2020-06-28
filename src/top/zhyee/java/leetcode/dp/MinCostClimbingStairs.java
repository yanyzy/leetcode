package top.zhyee.java.leetcode.dp;

public class MinCostClimbingStairs {
    
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
    
    public static void main(String[] args) {
        int[] cost = new int[]{0, 0, 1, 1};
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(cost));
    }
}
