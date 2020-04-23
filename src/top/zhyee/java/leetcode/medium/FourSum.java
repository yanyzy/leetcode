package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 18. 四数之和
 * <p>
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/4sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FourSum {
    /**
     * 求三数之和的方法
     * 再对数组去重
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int start = j + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int count = nums[i] + nums[j] + nums[start] + nums[end];
                    if (count == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[start]);
                        list.add(nums[end]);
                        listList.add(list);
                        start++;
                        end--;
                    } else if (count < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return listList.stream()
                .distinct()
                .collect(Collectors.toList());
    }
    
    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().fourSum(nums, 0));
    }
}
