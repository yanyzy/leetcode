package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/26 下午5:29
 */
public class IntegerToRoman {

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }

        String[][] strings = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}};

        StringBuilder stringBuilder = new StringBuilder();

        int i = 0;
        while (num > 0) {
            stringBuilder.insert(0, strings[i][num % 10]);
            num /= 10;
            i++;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }

}
