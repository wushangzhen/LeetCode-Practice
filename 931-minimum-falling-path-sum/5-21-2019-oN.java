class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = A[0][i];
        }
        int old = 1;
        int now = 0;
        for (int i = 1; i < n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < n; j++) {
                dp[now][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    dp[now][j] = Math.min(dp[old][j - 1] + A[i][j], dp[now][j]);
                }
                if (j != n - 1) {
                    dp[now][j] = Math.min(dp[old][j + 1] + A[i][j], dp[now][j]);
                }
                dp[now][j] = Math.min(dp[old][j] + A[i][j], dp[now][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(dp[now][i], min);
        }
        return min;
    }
}
