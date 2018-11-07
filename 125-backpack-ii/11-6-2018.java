public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @param V: Given n items with value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
                if (j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1] && dp[i - 1][j - A[i - 1]] != Integer.MIN_VALUE) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        for (int j = m; j >= 0; j--) {
            if (dp[n][j] != Integer.MIN_VALUE) {
                return dp[n][j];
            }
        }
        return 0;
    }
}
