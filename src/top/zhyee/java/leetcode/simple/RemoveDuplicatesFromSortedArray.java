package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/25 下午2:27
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int len = nums.length;
        int j = 0;
        int i = 0;

        while (i < len - j - 1) {
            if (nums[i] == nums[i + 1]) {
                System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
                j++;
            } else {
                i++;
            }
            if (i == len - j - 1) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1};
        int len = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        System.out.println("len = " + len);

        for (int i = 0; i < len; i++) {
            System.out.println(nums[i]);
        }
    }
}
