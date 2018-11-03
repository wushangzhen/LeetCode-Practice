class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    dp[i][j] = costs[i][j];
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i - 1][k], dp[i][j]);
                    }
                }
                dp[i][j] += costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
        
    }
}
