package top.zhyee.java.leetcode.medium;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        //填充第一排
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        if (grid.length == 1) {
            return dp[0][dp[0].length - 1];
        }
        dp[1][0] = grid[1][0];
        //从第二排开始遍历
        for (int i = 1; i < grid.length; i++) {
            int j = 0;
            while (j < grid[i].length) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
                }
                j++;
            }
        }
        
        return dp[dp.length - 1][dp[dp.length - 1].length - 1];
    }
    
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new MinimumPathSum().minPathSum(grid));
    }
}
