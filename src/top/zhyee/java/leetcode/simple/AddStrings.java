package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/30 上午11:32
 */


/**
 * 415. 字符串相加
 * <p>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 注意：
 * <p>
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder stringBuilder = new StringBuilder();

        int num1Index = num1.length() - 1;
        int num2Index = num2.length() - 1;
        //进位的值
        int next = 0;

        while (num1Index >= 0 && num2Index >= 0) {
            //相加
            int i = (num1.charAt(num1Index) - '0') + (num2.charAt(num2Index) - '0') + next;
            next = 0;

            if (i >= 10) {
                next = i / 10;
                i = i % 10;
            }
            stringBuilder.append(i);
            num1Index--;
            num2Index--;
        }

        if (num1Index >= 0) {
            next = add(num1, num1Index, next, stringBuilder);
        } else if (num2Index >= 0) {
            next = add(num2, num2Index, next, stringBuilder);
        }

        if (next > 0) {
            stringBuilder.append(next);
        }

        return stringBuilder.reverse().toString();

    }

    private int add(String num, int index, int next, StringBuilder stringBuilder) {
        while (index >= 0) {
            int i = (num.charAt(index) - '0') + next;
            next = 0;

            if (i >= 10) {
                next = i / 10;
                i = i % 10;
            }
            stringBuilder.append(i);
            index--;
        }

        return next;
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("9", "1"));
    }
}
