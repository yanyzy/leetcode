package top.zhyee.java.leetcode.dp;

public class NumArray {
    
    private int[] dp;
    
    public NumArray(int[] nums) {
        if(nums.length == 0){
            return;
        }
        dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        return i==0 ? dp[j] : dp[j] - dp[i-1];
    }
}
