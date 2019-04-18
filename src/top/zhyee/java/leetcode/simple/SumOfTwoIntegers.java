package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/4/4 上午10:35
 */


/**
 * 371. 两整数之和
 * <p>
 * <p>
 * 不使用运算符 + 和 - ​​​​​​​，计算两整数 ​​​​​​​a 、b ​​​​​​​之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = 1, b = 2
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: a = -2, b = 3
 * 输出: 1
 */
public class SumOfTwoIntegers {

    public int getSum(int a, int b) {

        if (b > 0) {
            for (int i = 0; i < b; i++) {
                a++;
            }
        } else if (b < 0) {
            for (int i = b; i < 0; i++) {
                a--;
            }
        }

        return a;
    }
}
