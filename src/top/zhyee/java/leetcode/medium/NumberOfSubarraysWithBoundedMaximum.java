package top.zhyee.java.leetcode.medium;


/**
 * 795. 区间子数组个数
 * <p>
 * 给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。
 * <p>
 * 求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。
 * <p>
 * 例如 :
 * 输入:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * 输出: 3
 * 解释: 满足条件的子数组: [2], [2, 1], [3].
 * 注意:
 * <p>
 * L, R  和 A[i] 都是整数，范围在 [0, 10^9]。
 * 数组 A 的长度范围在[1, 50000]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-subarrays-with-bounded-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfSubarraysWithBoundedMaximum {
    
    /**
     * 计算区间子数组个数
     *
     * @param A
     * @param L
     * @param R
     * @return
     */
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L - 1);
    }
    
    public int count(int[] A, int bound) {
        int count = 0;
        int total = 0;
        for (int value : A) {
            total = value <= bound ? total + 1 : 0;
            count = count + total + 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        System.out.println(new NumberOfSubarraysWithBoundedMaximum().numSubarrayBoundedMax(nums, 32, 69));
    }
}
