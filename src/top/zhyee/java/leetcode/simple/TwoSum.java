package top.zhyee.java.leetcode.simple;

import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] returnInt = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    returnInt[0] = i;
                    returnInt[1] = j;
                }
            }
        }
        return returnInt;

    }

    public static void main(String[] args) {
        int[] ints = new int[]{2, 7, 8, 3};
        int target = 11;
        int[] i = new TwoSum().twoSum(ints, target);
        System.out.println(Arrays.toString(i));
    }
}
