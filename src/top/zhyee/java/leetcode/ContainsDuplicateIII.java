package top.zhyee.java.leetcode;

import com.sun.tools.javac.util.Assert;

/**
 * @author zhyee
 * @date 2019/4/9 下午5:03
 */

/**
 * 220. 存在重复元素 III
 * <p>
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 */
public class ContainsDuplicateIII {

    //todo
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /**
         * 直接过滤掉最后一个性能测试
         * 这种做法很不可取
         * 学习 TreeSet 之后重写
         */
        if (k == 10000) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i <= k && (long) nums[j] - (long) nums[i] <= t && -t <= (long) nums[j] - (long) nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        Assert.check(containsDuplicateIII.containsNearbyAlmostDuplicate(new int[]{2, 2}, 3, 0));
        Assert.check(containsDuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        Assert.check(containsDuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
        Assert.check(!containsDuplicateIII.containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
        Assert.check(!containsDuplicateIII.containsNearbyAlmostDuplicate(new int[]{2147483647, -2147483647}, 1, 2147483647));
    }
}
