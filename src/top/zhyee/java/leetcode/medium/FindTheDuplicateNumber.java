package top.zhyee.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 287. 寻找重复数
 * <p>
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-the-duplicate-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTheDuplicateNumber {
    
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> integerIntegerMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (integerIntegerMap.get(nums[i]) == null) {
                integerIntegerMap.put(nums[i], 0);
            } else {
                return nums[i];
            }
        }
        return 0;
    }
    
    /**
     * 快慢指针解法
     * @param nums
     * @return
     */
    //todo
    public int findDuplicateII(int[] nums) {
        if (nums.length < 3) {
            return nums[0];
        }
        int i = 1;
        int j = 2;
        while (nums[i] != nums[j]) {
            i = i + 1;
            j = j + 2;
            if (i > nums.length - 1) {
                i = i - nums.length;
            }
            if (j > nums.length - 1) {
                j = j - nums.length;
            }
        }
        return nums[i];
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 1, 4, 2};
        System.out.println(new FindTheDuplicateNumber().findDuplicateII(nums));
    
        int[] nums1 = new int[]{1, 3, 4, 2, 1};
        System.out.println(new FindTheDuplicateNumber().findDuplicateII(nums1));
    }
}
