package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhyee
 * @date 2019/4/30 上午10:24
 */

/**
 * 47. 全排列 II
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> listList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(nums, list, listList);

        return listList.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private void permute(int[] nums, ArrayList<Integer> list, List<List<Integer>> lists) {

        if (nums.length == 1) {
            list.add(nums[0]);
            lists.add(list);
            return;
        }

        for (int num : nums) {
            ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
            newList.add(num);
            permute(remove(nums, num), newList, lists);
        }

    }

    private int[] remove(int[] nums, int j) {
        int[] ints = new int[nums.length - 1];
        int k = 0;
        boolean flag = true;
        for (int num : nums) {
            if (num == j && flag) {
                flag = false;
                continue;
            }
            ints[k] = num;
            k++;
        }
        return ints;
    }

    public static void main(String[] args) {
        PermutationsII permutationsII = new PermutationsII();
        System.out.println(permutationsII.permuteUnique(new int[]{1, 1, 2}));
    }
}
