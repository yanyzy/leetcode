package top.zhyee.java.leetcode.medium;

import java.util.Arrays;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 * <p>
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumClosest {
    /**
     * 排序，再使用前后指针遍历
     * 根据三数之和对比大小
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        //排序
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int resCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int count = nums[i] + nums[start] + nums[end];
                if (count > target) {
                    if (Math.abs(count - target) < min) {
                        min = Math.abs(count - target);
                        resCount = count;
                    }
                    end--;
                } else if (count < target) {
                    start++;
                    if (Math.abs(count - target) < min) {
                        min = Math.abs(count - target);
                        resCount = count;
                    }
                } else {
                    return count;
                }
            }
        }
        return resCount;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, 3));
    }
}
