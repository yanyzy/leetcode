package top.zhyee.java.leetcode.medium;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/5/6 下午4:24
 */

/**
 * 238. 除自身以外数组的乘积
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 * <p>
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        int leftProduct = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct = leftProduct * nums[i];
            left[i] = leftProduct;
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProduct = rightProduct * nums[i];
            right[i] = rightProduct;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                nums[i] = right[i + 1];
            } else if (i == nums.length - 1) {
                nums[i] = left[i - 1];
            } else {
                nums[i] = left[i - 1] * right[i + 1];
            }
        }

        return nums;
    }


    public static void main(String[] args) {
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
