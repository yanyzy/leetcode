package top.zhyee.java.leetcode.medium;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/5/5 下午6:00
 */

/**
 * 462. 最少移动次数使数组元素相等 II
 * <p>
 * 给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * [1,2,3]
 * <p>
 * 输出:
 * 2
 * <p>
 * 说明：
 * 只有两个动作是必要的（记得每一步仅可使其中一个元素加1或减1）：
 * <p>
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */
public class MinimumMovestoEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int middle = nums[nums.length / 2];

        int count = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            count += middle - nums[i];
        }
        for (int i = nums.length / 2 + 1; i < nums.length; i++) {
            count += nums[i] - middle;
        }

        return count;
    }
}
