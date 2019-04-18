package top.zhyee.java.leetcode.simple;

/**
 * @author zhyee
 * @date 2019/3/26 上午10:38
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int sum = 0;
        while (n > 0) {
            sum = sum + (n % 10) * (n % 10);
            n = n / 10;
        }

        if (sum == 1) {
            return true;
        } else if (sum == 89) {
            return false;
        }
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
