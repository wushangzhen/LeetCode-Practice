class Solution {
    public int longestLine(int[][] M) {
        int n = M.length;
        if (n == 0) {
            return 0;
        }
        int m = M[0].length;
        int[][][] dp = new int[n][m][4];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (M[i][j] == 1) {
                    Arrays.fill(dp[i][j], 1);
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        dp[i][j][0] += dp[i - 1][j - 1][0];
                    }
                    if (i - 1 >= 0) {
                        dp[i][j][1] += dp[i - 1][j][1];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j][2] += dp[i][j - 1][2];
                    }
                    if (i - 1 >= 0 && j + 1 < m) {
                        dp[i][j][3] += dp[i - 1][j + 1][3];
                    }
                    for (int k = 0; k < 4; k++) {
                        max = Math.max(dp[i][j][k], max);
                    }
                }
            }
        }
        return max;
    }
}
