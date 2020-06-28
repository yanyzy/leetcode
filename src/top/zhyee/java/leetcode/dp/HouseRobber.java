package top.zhyee.java.leetcode.dp;

public class HouseRobber {
    
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[dp.length - 1];
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 3, 3, 21};
        System.out.println(new HouseRobber().rob(nums));
    }
}
