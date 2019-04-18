package top.zhyee.java.leetcode.medium;

/**
 * @author zhyee
 * @date 2019/4/17 下午5:49
 */

/**
 * 153. 寻找旋转排序数组中的最小值
 *
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 请找出其中最小的元素。
 *
 * 你可以假设数组中不存在重复元素。
 *
 * 示例 1:
 *
 * 输入: [3,4,5,1,2]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,5,6,7,0,1,2]
 * 输出: 0
 */
public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {

        int i = nums[0];

        if (i > nums[nums.length - 1]) {

            int index = nums.length - 1;
            while (index >= 0) {
                if (nums[index] < i) {
                    i = nums[index];
                    index--;
                } else {
                    return i;
                }
            }
        }
        return i;
    }
}
