class Solution {
    public int maxProfit(int[] prices) {
        int K = 2;
        int n = prices.length;
        int[][] dp = new int[n + 1][2 * K + 2];
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2 * K + 1; j += 2) {
                // 这些阶段是没有股票的，有两种
                //前 i - 1 天没有股票 相同状态
                // 在这一天卖了 不同状态 需要算收益
                dp[i][j] = dp[i - 1][j];
                if (i > 1 && j > 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2], dp[i][j]);
                }
            }
            for (int j = 2; j <= 2 * K + 1; j += 2) {
                // 这时候是手里面有股票的
                // 前 i - 1 天就有股票，需要算收益
                // 在这一天buy了，不同状态，不需要算收益
                if (i > 1) {
                    dp[i][j] = Math.max(dp[i - 1][j] + prices[i - 1] - prices[i - 2], dp[i][j]);
                }
                if (j > 1) {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j]);
                }
            }
        }
        // 最后是三种状态，1， 3， 5分别可能在最后一天，枚举最大值
        int res = 0;
        for (int j = 1; j <= 2 * K + 1; j += 2) {
            res = Math.max(res, dp[n][j]);
        }
        return res;
    }
}
