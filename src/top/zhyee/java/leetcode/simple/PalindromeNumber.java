package top.zhyee.java.leetcode.simple;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        boolean b = false;
        int y = 0;
        int z = x;
        while (z > 0) {
            y = y * 10 + z % 10;
            z = z / 10;
        }
        if (y == x) {
            b = true;
        }
        return b;

    }

    public static void main(String[] args) {
        int x = -1;
        System.out.println(new PalindromeNumber().isPalindrome(x));
    }
}
