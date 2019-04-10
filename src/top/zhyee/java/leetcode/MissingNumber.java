package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/4/9 下午5:46
 */


/**
 * 268. 缺失数字
 * <p>
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,0,1]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 * 说明:
 * 你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现?
 */
public class MissingNumber {

    public int missingNumber(int[] nums) {
        int[] nums1 = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            nums1[nums[i]] = nums[i];
        }
        for (int i = 0; i < nums1.length; i++) {
            if (i != 0 && nums1[i] == 0) {
                return i;
            }
        }
        return 0;
    }
}
