package top.zhyee.java.leetcode;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/3/6 下午5:02
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == val) {
                remove(nums, i);
                count--;
                i--;
            }
        }
        return count;
    }

    private void remove(int[] nums, int i) {
        while (i < nums.length - 1) {
            nums[i] = nums[i + 1];
            i++;
        }

    }

    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int i = removeElement.removeElement(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}
