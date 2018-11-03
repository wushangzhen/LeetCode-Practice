class Solution {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int m = costs[0].length;
        int[][] dp = new int[2][m];
        int now = 0;
        int old = 0;
        for (int i = 0; i < n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < m; j++) {
                dp[now][j] = Integer.MAX_VALUE;
                if (i == 0) {
                    dp[now][j] = costs[i][j];
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        dp[now][j] = Math.min(dp[old][k], dp[now][j]);
                    }
                }
                dp[now][j] += costs[i][j];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[now][j]);
        }
        return res;
        
    }
}
