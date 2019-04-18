package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/4/11 上午10:48
 */

/**
 * 414. 第三大的数
 *
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 *
 * 示例 1:
 *
 * 输入: [3, 2, 1]
 *
 * 输出: 1
 *
 * 解释: 第三大的数是 1.
 * 示例 2:
 *
 * 输入: [1, 2]
 *
 * 输出: 2
 *
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 * 示例 3:
 *
 * 输入: [2, 2, 3, 1]
 *
 * 输出: 1
 *
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 */
public class ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }

        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int flag = 0;
        boolean f=true;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==Integer.MIN_VALUE&&f){
                flag++;
                f=false;
            }
            if (nums[i] > max) {
                flag++;
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            } else if (nums[i] < max && nums[i] > secondMax) {
                flag++;
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] < secondMax && nums[i] > thirdMax) {
                flag++;
                thirdMax = nums[i];
            }
        }

        return flag >= 3 ? thirdMax : max;
    }

    public static void main(String[] args) {
        ThirdMaximumNumber thirdMaximumNumber = new ThirdMaximumNumber();
        System.out.println(thirdMaximumNumber.thirdMax(new int[]{5, 2, 2}));
    }
}
