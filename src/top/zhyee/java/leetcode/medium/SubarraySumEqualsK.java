package top.zhyee.java.leetcode.medium;

/**
 * 560. 和为K的子数组
 * <p>
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * <p>
 * 示例 1 :
 * <p>
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 * <p>
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = i + 1;
            int count = nums[i];
            if (count == k) {
                total++;
            }
            while (next < nums.length) {
                count = count + nums[next];
                if (count == k) {
                    total++;
                }
                next++;
            }
        }
        return total;
    }
}
