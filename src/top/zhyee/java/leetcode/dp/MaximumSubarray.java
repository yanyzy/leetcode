package top.zhyee.java.leetcode.dp;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
        }
        
        return Arrays.stream(dp).max().getAsInt();
    }
}
