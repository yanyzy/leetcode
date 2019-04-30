package top.zhyee.java.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhyee
 * @date 2019/4/29 下午4:51
 */

/**
 * 46. 全排列
 * <p>
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,3]
 * 输出:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> listList = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        permute(nums, list, listList);
        return listList;
    }

    private List<List<Integer>> permute(int[] nums, ArrayList<Integer> list, List<List<Integer>> lists) {

        if (nums.length == 1) {
            list.add(nums[0]);
            lists.add(list);
            return lists;
        }

        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> newList = (ArrayList<Integer>) list.clone();
            newList.add(nums[i]);
            permute(remove(nums, nums[i]), newList, lists);
        }

        return lists;
    }

    private int[] remove(int[] nums, int j) {
        int[] ints = new int[nums.length - 1];
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != j) {
                ints[k] = nums[i];
                k++;
            }
        }
        return ints;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2, 3}));
    }
}
