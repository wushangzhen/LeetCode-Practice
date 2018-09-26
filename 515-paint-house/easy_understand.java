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
        int[][] dp = new int[2][3];
        int old = 0;
        int now = 0;
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        for (int i = 1; i < n; i++) {
            old = now;
            now = 1 - now;
            dp[now][0] = Math.min(dp[old][1], dp[old][2]) + costs[i][0];
            dp[now][1] = Math.min(dp[old][0], dp[old][2]) + costs[i][1];
            dp[now][2] = Math.min(dp[old][0], dp[old][1]) + costs[i][2];
        }
        return Math.min(dp[now][0], Math.min(dp[now][1], dp[now][2]));
    }
}
