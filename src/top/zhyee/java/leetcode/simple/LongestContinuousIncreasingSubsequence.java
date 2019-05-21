package top.zhyee.java.leetcode.simple;

/*
 * @author zhyee
 * @date 2019/5/20 下午5:03
 */

/**
 * 674. 最长连续递增序列
 * <p>
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * 示例 2:
 * <p>
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 */
public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {


        if (nums.length == 0) {
            return 0;
        }
        int len = 1;
        int maxLen = 1;
        int last = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                len++;
            } else {
                len = 1;
            }
            last = nums[i];
            maxLen = Math.max(len, maxLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        System.out.println(longestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{1, 3, 5, 4, 2, 3, 4, 5}));
    }
}
