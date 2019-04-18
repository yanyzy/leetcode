package top.zhyee.java.leetcode.simple;

/*
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

    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                //在附近寻找
                return find(target, mid, nums);
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        if (lo == hi) {
            if (nums[lo] == target) {
                return new int[]{lo, lo};
            }
        }
        return new int[]{first, last};
    }

    private int[] find(int target, int mid, int[] nums) {
        int first = mid;
        int last = mid;
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] > target) {
                last = i - 1;
                break;
            } else {
                last = i;
            }
        }
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] < target) {
                first = i + 1;
                break;
            } else {
                first = i;
            }
        }
        return new int[]{first, last};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstLastPositionOfElementInSortedArray().searchRange(new int[]{1,1,2}, 1)));
    }
}
