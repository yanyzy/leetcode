package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/27 下午10:43
 */

import java.util.Arrays;

/**
 * 905. 按奇偶排序数组
 * <p>
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            if (A[lo] % 2 != 0) {
                if (A[hi] % 2 == 0) {
                    int temp = A[lo];
                    A[lo] = A[hi];
                    A[hi] = temp;
                    lo++;
                    hi--;
                } else {
                    hi--;
                }
            } else {
                lo++;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(new int[]{3,1,2,4})));
    }
}
