package top.zhyee.java.leetcode.medium;

/**
 * @author zhyee
 * @date 2019/5/6 下午4:46
 */

//todo 未通过
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        int leftMax = nums[0];
        int leftProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                leftProduct = 1;
                leftMax = Math.max(leftMax, 0);
            } else {
                leftProduct = leftProduct * nums[i];
                leftMax = Math.max(leftMax, leftProduct);
            }
        }

        int rightMax = nums[nums.length - 1];
        int rightProduct = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                rightProduct = 1;
                rightMax = Math.max(rightMax, 0);
            } else {
                rightProduct = rightProduct * nums[i];
                rightMax = Math.max(rightMax, rightProduct);
            }
        }
        return Math.max(rightMax, leftMax);
    }

    public static void main(String[] args) {
        MaximumProductSubarray maximumProductSubarray = new MaximumProductSubarray();
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-3,0,1,-2}));
        System.out.println(maximumProductSubarray.maxProduct(new int[]{-3,0,-2}));
    }
}
