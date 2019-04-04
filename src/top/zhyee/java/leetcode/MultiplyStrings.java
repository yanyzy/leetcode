package top.zhyee.java.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhyee
 * @date 2019/4/3 下午8:28
 */


/**
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */

//todo
public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        List<String> strings = new ArrayList<>();

        for (int i = num2.length() - 1; i >= 0; i--) {
            int k = num2.charAt(i) - '0';
            int next = 0;
            Stack<Integer> stack1 = new Stack<>();

            for (int j = num1.length() - 1; j >= 0; j--) {
                int m = num1.charAt(j) - '0';
                int product = k * m + next;
                next = 0;

                if (product >= 10) {
                    next = product / 10;
                    product = product % 10;
                }
                stack1.push(product);

                if (j == 0) {
                    int sum = next;
                    while (!stack1.empty()) {
                        sum = sum * 10 + stack1.pop();
                    }
                    String string = sum + "";
                    for (int n = 0; n < num2.length() -1- i; n++) {
                        string = string + 0;
                    }
                    strings.add(string);
                }
            }
        }

        String sum = strings.get(0);
        int o = 1;
        while (o < strings.size()) {
            sum = addStrings(sum, strings.get(o));
            o++;
        }

        return sum;
    }


    /**
     * 使用之前的字符串加法
     *
     * @param num1
     * @param num2
     * @return
     */
    private String addStrings(String num1, String num2) {

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
        MultiplyStrings multiplyStrings = new MultiplyStrings();
        System.out.println(multiplyStrings.multiply("9", "9"));
    }
}
