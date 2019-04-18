package top.zhyee.java.leetcode.simple;

import java.util.*;

/**
 * @author zhyee
 * @date 2019/3/29 上午12:00
 */

/**
 * 229. 求众数 II
 *
 * 给定一个大小为 n 的数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1)。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: [3]
 * 示例 2:
 *
 * 输入: [1,1,1,3,3,2,2,2]
 * 输出: [1,2]
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        int m = nums.length / 3;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int i : nums) {
            if (Objects.isNull(integerIntegerMap.get(i))) {
                integerIntegerMap.put(i, 1);
            } else {
                integerIntegerMap.put(i, integerIntegerMap.get(i) + 1);
            }
            if (integerIntegerMap.get(i) > m && !list.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElementII().majorityElement(new int[]{1, 1, 1, 3, 3, 2, 2, 2}));
    }
}
