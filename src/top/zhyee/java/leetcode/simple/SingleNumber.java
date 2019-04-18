package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/4/10 下午4:44
 */

/**
 * 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 说明：
 * <p>
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class SingleNumber {

    /**
     * 异或，相同为0，不同为1
     * 异或一个数两次为原来的数
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }

        return result;
    }

}
