package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhyee
 * @date 2019/4/8 下午10:34
 */


/**
 * 217. 存在重复元素
 * <p>
 * 给定一个整数数组，判断是否存在重复元素。
 * <p>
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,3,1]
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4]
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Map<Integer, String> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, "");
            }
        }
        return false;
    }
}
