class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        if (k > n / 2) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (i != 0 && prices[i] > prices[i - 1]) {
                    res += prices[i] - prices[i - 1];
                }
            }
            return res;
        }
        int[][] dp = new int[n + 1][2 * k + 2];
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * k + 1; j += 2) {
                dp[i][j] = dp[i - 1][j];
                if (i > 1 && j > 1) { // j > 1 is necessary because in this situation it cannot be 1st state
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2]);
                }
            }
            for (int j = 2; j <= 2 * k + 1; j += 2) {
                if (i > 1) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                }
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
            }
        }
        int res = 0;
        for (int j = 1; j <= 2 * k + 1; j += 2) {
            res = Math.max(res, dp[n][j]);
        }
        return res;
    }
}
