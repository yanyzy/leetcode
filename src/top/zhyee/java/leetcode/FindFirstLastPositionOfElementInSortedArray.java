package top.zhyee.java.leetcode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/3/27 上午11:08
 */
public class FindFirstLastPositionOfElementInSortedArray {

    //todo
    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        int lo = 0;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                if (nums[mid + 1] > target) {
                    last = mid;
                    hi = mid - 1;
                } else if (nums[mid - 1] < target) {
                    first = mid;
                    lo = mid + 1;
                }
            }
        }

        return new int[]{first, last};
    }
}
