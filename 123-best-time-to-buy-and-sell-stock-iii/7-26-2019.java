class Solution {
    public int maxProfit(int[] prices) {
        // compute the delta is the key
        int n = prices.length;
        int[][] dp = new int[n + 1][5];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                if (j % 2 == 0) {
                    // no stock in hands
                    // case 1: same as yesterday
                    dp[i][j] = dp[i - 1][j];
                    // case 2: sell the stock today
                    if (i > 1 && j != 0) {
                        // we have to have an extra day to buy stock
                        dp[i][j] = Math.max(dp[i - 1][j - 1] + prices[i - 1] - prices[i - 2], dp[i][j]);
                    }
                } else {
                    // have stock in hands
                    // case 1: buy stock today
                    dp[i][j] = dp[i - 1][j - 1];
                    if (i >= 2) {
                        // same as yesterday
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + prices[i - 1] - prices[i - 2]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (i % 2 == 0) {
                max = Math.max(dp[n][i], max);
            }
        }
        return max;
    }
}
