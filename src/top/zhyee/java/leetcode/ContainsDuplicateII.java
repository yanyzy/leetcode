package top.zhyee.java.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhyee
 * @date 2019/4/9 下午3:56
 */


/**
 * 219. 存在重复元素 II
 * <p>
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * <p>
 * <p>
 * 这道题很迷，，看不明白
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i - map.get(nums[i]) > k) {
                    map.put(nums[i], i);
                } else {
                    return true;
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
