package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/4/17 下午5:39
 */


/**
 * 81. 搜索旋转排序数组 II
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 * 进阶:
 *
 * 这是 搜索旋转排序数组 的延伸题目，本题中的 nums  可能包含重复元素。
 * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {

        if (nums.length == 0) {
            return false;
        }
        int left = 0;
        int right = nums.length - 1;
        if (nums[0] > target) {
            if (nums[0] < nums[nums.length - 1]) {
                return false;
            }
            while (left <= right) {
                if (nums[right] == target||nums[left] == target) {
                    return true;
                } else if (nums[right] < target) {
                    return false;
                }
                left++;
                right--;
            }
        } else if (nums[0] < target) {
            while (left <= right) {
                if (nums[left] == target||nums[right] == target) {
                    return true;
                } else if (nums[left] > target) {
                    return false;
                }
                left++;
                right--;
            }
        }else {
            return true;
        }
        return false;
    }
}
