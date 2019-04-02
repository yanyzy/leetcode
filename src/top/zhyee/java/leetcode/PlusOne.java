package top.zhyee.java.leetcode;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/2 下午5:55
 */

/**
 * 66. 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {

        int index = digits.length - 1;
        int add = digits[index] + 1;

        if (add < 10) {
            digits[index] = add;
            return digits;
        }

        int next = add / 10;
        digits[index] = add % 10;
        index--;

        while (next > 0 && index >= 0) {
            add = digits[index] + next;
            next = 0;

            if (add >= 10) {
                next = add / 10;
                add = add % 10;
            }
            digits[index] = add;
            index--;
        }

        if (next > 0) {
            int[] rs = new int[digits.length + 1];
            rs[0] = next;
            System.arraycopy(digits, 0, rs, 1, digits.length);
            return rs;
        }
        return digits;
    }

    public static void main(String[] args) {
        PlusOne plusOne = new PlusOne();
        System.out.println(Arrays.toString(plusOne.plusOne(new int[]{9})));
    }
}
