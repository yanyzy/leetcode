package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/27 下午10:56
 */

/**
 * 258. 各位相加
 * <p>
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 * 进阶:
 * 你可以不使用循环或者递归，且在 O(1) 时间复杂度内解决这个问题吗？
 */
public class AddDigits {

    public int addDigits(int num) {

        int i = num;

        if (i >= 10) {
           i = addDigits(add(i));
        }

        return i;
    }

    private int add(int num) {
        int i = 0;

        while (num > 0) {
            i += num % 10;
            num /= 10;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(10));
    }
}
