package top.zhyee.java.leetcode.simple;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/8 上午11:12
 */


/**
 * 167. 两数之和 II - 输入有序数组
 * <p>
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 说明:
 * <p>
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * <p>
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int pre = target - numbers[0];
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if (i != 0) {
                if (temp == pre) {
                    continue;
                }
            }
            for (int j = i + 1; j < numbers.length; j++) {
                if (temp == numbers[j]) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }


    public static void main(String[] args) {
        TwoSumII twoSumII = new TwoSumII();
        System.out.println(Arrays.toString(twoSumII.twoSum(new int[]{0, 0, 3, 4}, 0)));
    }
}
