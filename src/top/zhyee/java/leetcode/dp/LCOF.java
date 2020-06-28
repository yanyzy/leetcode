package top.zhyee.java.leetcode.dp;

import java.util.Arrays;

public class LCOF {
    
    public int maxSubArray(int[] nums) {
        int[] array = new int[nums.length];
        array[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = array[i - 1];
            if (t >= 0) {
                array[i] = t + nums[i];
            } else {
                array[i] = nums[i];
            }
        }
        return Arrays.stream(array).max().getAsInt();
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new LCOF().maxSubArray(nums));
    }
}
