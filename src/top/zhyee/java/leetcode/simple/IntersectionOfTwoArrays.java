package top.zhyee.java.leetcode.simple;

import java.util.*;

/**
 * @author zhyee
 * @date 2019/4/28 下午9:24
 */

/**
 * 349. 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {

            if (!map.containsKey(nums1[i])) {
                map.put(nums1[i], null);
            }
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && Objects.isNull(map.get(nums2[i]))) {
                list.add(nums2[i]);
                map.put(nums2[i], "get");
            }
        }

        int[] rs = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            rs[i] = list.get(i);
        }

        return rs;
    }
}
