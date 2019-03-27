package top.zhyee.java.leetcode;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhyee
 * @date 2019/3/26 下午11:30
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Set<String> exist = new HashSet<>();

        Integer pevious = null;

        for (int i = 0; i < nums.length; i++) {

            int j = 0 - nums[i];
            if (pevious != null && pevious == j) {
                continue;
            }


            Map<Integer, Integer> integers = new HashMap<>();
            for (int k = i + 1; k < nums.length; k++) {
                int m = j - nums[k];
                if (integers.containsKey(m)) {

                    int[] result = new int[]{nums[i], nums[k], m};
                    Arrays.sort(result);

                    String exsitKey = result[0] + "-" + result[1] + "-" + result[2];
                    if (!exist.contains(exsitKey)) {
                        lists.add(Arrays.asList(nums[i], nums[k], m));
                        exist.add(exsitKey);
                    }


                }
                integers.put(nums[k], 0);
            }

            pevious = j;
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
