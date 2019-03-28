package top.zhyee.java.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhyee
 * @date 2019/3/28 下午4:48
 */

/**
 * 169. 求众数
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int m = nums.length / 2;
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int i : nums) {
            if(Objects.isNull(integerIntegerMap.get(i))) {
                integerIntegerMap.put(i, 1);
            }else {
                integerIntegerMap.put(i, integerIntegerMap.get(i) + 1);
            }
            if(integerIntegerMap.get(i)>m){
                return i;
            }
        }
        return 0;
    }

}
