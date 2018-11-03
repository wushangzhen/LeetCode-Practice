public class Solution {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] board) {
        // write your code here
        if (board == null || board.length == 0) {
            return 0;
        }
        int n = board.length;
        int m = board[0].length;
        if (m == 0) {
            return 0;
        }
        if (board[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 0;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (board[i][j] == 1) {
                    dp[i][j] = 0; 
                    continue;
                }
                if (i == 0 && j != 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                } 
                if (j == 0 && i != 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                if (dp[i - 1][j] != 0 && dp[i][j - 1] != 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    continue;
                }
                if (dp[i - 1][j] == 0 && dp[i][j - 1] != 0) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (dp[i][j - 1] == 0 && dp[i - 1][j] != 0) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
