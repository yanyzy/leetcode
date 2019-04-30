package top.zhyee.java.leetcode.medium;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/30 上午10:38
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {

        int aindex = -1;
        int a = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                aindex = i - 1;
                a = nums[i - 1];
                break;
            }
        }

        if (aindex == -1) {
            Arrays.sort(nums);
            return;
        }

        int bindex = -1;
        int b = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > a) {
                b = nums[i];
                bindex = i;
                break;
            }
        }

        nums[aindex] = b;
        nums[bindex] = a;

        Arrays.sort(nums, aindex + 1, nums.length);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
