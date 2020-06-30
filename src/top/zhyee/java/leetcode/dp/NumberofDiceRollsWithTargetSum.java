package top.zhyee.java.leetcode.dp;

//TODO
public class NumberofDiceRollsWithTargetSum {
    public int numRollsToTarget(int d, int f, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < f; j++) {
                if (i >= j) {
                    dp[i] += dp[i - j];
                }
            }
        }
        return dp[target];
    }
    
    public static void main(String[] args) {
        System.out.println(new NumberofDiceRollsWithTargetSum().numRollsToTarget(1, 6, 3));
    }
}
