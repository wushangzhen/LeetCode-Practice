public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
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
                int count = 1;
                for (int k = 0; k < i; k++) {
                    dp[i][j] = Math.max(dp[k][j], dp[i][j]);
                }
                while (j >= count * A[i - 1] 
                    && dp[i][j - count * A[i - 1]] != Integer.MIN_VALUE) {
                    for (int k = 0; k < i; k++) {
                        dp[i][j] = Math.max(dp[k][j - count * A[i - 1]] + count * V[i - 1], 
                        dp[i][j]);
                    }
                    count++;
                }
            }
        }
        for (int j = m; j >= 0; j++) {
            if (dp[n][j] != Integer.MIN_VALUE) {
                return dp[n][j];
            }
        }
        return 0;
    }
}
