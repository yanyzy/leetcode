package top.zhyee.java.leetcode.simple;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2019/4/17 下午4:43
 */

/**
 * 33. 搜索旋转排序数组
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[0] > target) {

            if (nums[0] < nums[nums.length - 1]) {
                return -1;
            }

            while (left <= right) {
                if (nums[right] == target) {
                    return right;
                } else if (nums[right] < target) {
                    return -1;
                } else if (nums[left] == target) {
                    return left;
                }
                left++;
                right--;
            }

        } else if (nums[0] < target) {

            if (nums[0] < nums[nums.length - 1]) {
                //正序数组未被反转
                while (left <= right) {
                    if (nums[left] == target) {
                        return left;
                    } else if (nums[right] == target) {
                        return right;
                    } else if (nums[left] > target) {
                        return -1;
                    }
                    left++;
                    right--;
                }
                return -1;
            }

            while (left <= right) {
                if (nums[left] == target) {
                    return left;
                } else if (nums[left] > target) {
                    return -1;
                } else if (nums[right] == target) {
                    return right;
                }
                left++;
                right--;
            }

        } else {
            return 0;
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        Assert.check(searchInRotatedSortedArray.search(new int[]{1, 3}, 3) == 1);
        Assert.check(searchInRotatedSortedArray.search(new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2) == 3);
        Assert.check(searchInRotatedSortedArray.search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8) == 4);
    }
}
