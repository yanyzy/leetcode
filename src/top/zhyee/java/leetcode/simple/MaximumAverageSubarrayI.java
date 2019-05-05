package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/5/5 下午5:08
 */

/**
 * 643. 子数组最大平均数 I
 * <p>
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 注意:
 * <p>
 * 1 <= k <= n <= 30,000。
 * 所给数据范围 [-10,000，10,000]
 */
public class MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {
        //计算第一个值
        double count = 0;
        for (int i = 0; i < k; i++) {
            count += nums[i];
        }
        double max = count / k;

        /**
         * 滑动窗口法
         * 每次减去最左边的值，加上一个右边的值
         */
        int j = 1;
        while (j + k <= nums.length) {
            count = count - nums[j - 1] + nums[j + k - 1];
            max = Math.max(max, count / k);
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumAverageSubarrayI maximumAverageSubarrayI = new MaximumAverageSubarrayI();
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        System.out.println(maximumAverageSubarrayI.findMaxAverage(new int[]{-1}, 1));
    }
}
