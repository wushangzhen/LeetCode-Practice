public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int m = costs[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][m];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        dp[i][j] = Math.min(dp[i - 1][k] + costs[i - 1][j], dp[i][j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(dp[n][j], res);
        }
        return res;
    }
}
