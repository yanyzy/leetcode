package top.zhyee.java.leetcode.medium;

/**
 * 713. 乘积小于K的子数组
 * <p>
 * 给定一个正整数数组 nums。
 * <p>
 * 找出该数组内乘积小于 k 的连续的子数组的个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [10,5,2,6], k = 100
 * 输出: 8
 * 解释: 8个乘积小于100的子数组分别为: [10], [5], [2], [6], [10,5], [5,2], [2,6], [5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于100的子数组。
 * 说明:
 * <p>
 * 0 < nums.length <= 50000
 * 0 < nums[i] < 1000
 * 0 <= k < 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-product-less-than-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarrayProductLessThanK {
    
    /**
     * 给定两个指针，在乘积小于 k 之前，都只移动末尾指针
     * 当乘积 >= k 时，根据情况。增加的个数应为 end-start+1
     * 当发现数值过大，则移动起始指针直到数值变小
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int total = 0;
        int start = 0;
        int end = 0;
        int prod = 1;
        while (end < nums.length) {
            prod = prod * nums[end];
            while (prod >= k && start < end) {
                prod = prod / nums[start++];
            }
            total = total + (end - start + 1);
            end++;
        }
        return total;
    }
    
    public static void main(String[] args) {
        int nums[] = new int[]{10, 5, 2, 6};
        System.out.println(new SubarrayProductLessThanK().numSubarrayProductLessThanK(nums, 100));
    }
}
