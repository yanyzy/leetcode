package top.zhyee.java.leetcode;

/**
 * @author zhyee
 * @date 2019/3/26 下午5:01
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == 'I') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'V') {
                    sum = sum + 4;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'X') {
                    sum = sum + 9;
                    i++;
                } else {
                    sum = sum + 1;
                }
            } else if (c == 'V') {
                sum = sum + 5;

            } else if (c == 'X') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'L') {
                    sum = sum + 40;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'C') {
                    sum = sum + 90;
                    i++;
                } else {
                    sum = sum + 10;
                }

            } else if (c == 'L') {
                sum = sum + 50;

            } else if (c == 'C') {
                if (i < s.length() - 1 && s.charAt(i + 1) == 'D') {
                    sum = sum + 400;
                    i++;
                } else if (i < s.length() - 1 && s.charAt(i + 1) == 'M') {
                    sum = sum + 900;
                    i++;
                } else {
                    sum = sum + 100;
                }

            } else if (c == 'D') {
                sum = sum + 500;

            } else if (c == 'M') {
                sum = sum + 1000;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("XXVII"));
    }
}
