package top.zhyee.java.leetcode;

import java.util.Arrays;

/**
 * @author zhyee
 * @date 2019/4/2 下午5:55
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
