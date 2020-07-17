package top.zhyee.java.leetcode.medium;

public class LongestPalindromicSubstring {
    
    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return s;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        
        //填充所有 i=j
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }
        
        int max = 1;
        int start = 0;
        int end = 0;
        for (int j = 1; j < s.length(); j++) {
            int i = 0;
            while (i < j) {
                boolean temp = s.charAt(i) == s.charAt(j);
                if (temp) {
                    if (i + 1 >= j - 1) {
                        dp[i][j] = temp;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    if (dp[i][j] && j - i + 1 > max) {
                        max = j - i + 1;
                        start = i;
                        end = j;
                    }
                } else {
                    dp[i][j] = false;
                }
                i++;
            }
        }
        return s.substring(start, end + 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("abcda"));
    }
}
