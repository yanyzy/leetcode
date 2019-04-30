package top.zhyee.java.leetcode.medium;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/30 上午10:38
 */

/**
 * 31. 下一个排列
 * <p>
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {


    /**
     * 使用字典序算法
     * 参考 https://blog.csdn.net/HappyRocking/article/details/83619392
     *
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        //首先从右到左遍历，找到第一个 左元素 < 右元素 的情况，记下左元素的位置 aindex 与值 a
        int aindex = -1;
        int a = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                aindex = i - 1;
                a = nums[i - 1];
                break;
            }
        }

        //如果没有，则是全排列的最后一种情况，倒序，此时将数组按正序排序
        if (aindex == -1) {
            Arrays.sort(nums);
            return;
        }

        //再次从右到左遍历，找到第一个 大于 a 的情况，记下位置 bindex 与值 b
        int bindex = -1;
        int b = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > a) {
                b = nums[i];
                bindex = i;
                break;
            }
        }

        //交换 a、b
        nums[aindex] = b;
        nums[bindex] = a;

        //对 aindex 后面的值进行排序
        Arrays.sort(nums, aindex + 1, nums.length);
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums = new int[]{1, 3, 2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
