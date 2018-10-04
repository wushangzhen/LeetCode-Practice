public class Solution {
    /**
     * @param matrix: A 2D-array of integers
     * @return: an integer
     */
    public int longestContinuousIncreasingSubsequence2(int[][] matrix) {
        // write your code here
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = 1;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    if (matrix[i - 1][j] < matrix[i][j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                } 
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (i == n - 1) {
                    dp[i][j] = dp[i][j];
                } else {
                    if (matrix[i][j] > matrix[i + 1][j]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i + 1][j] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i][j];
                } else {
                    if (matrix[i][j] > matrix[i][j - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) {
                    dp[i][j] = dp[i][j];
                } else {
                    if (matrix[i][j] > matrix[i][j + 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j + 1] + 1);
                    } else {
                        dp[i][j] = dp[i][j];
                    }
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
