public class Solution {
    /**
     * @param prices: the prices
     * @param n: the length of rod
     * @return: the max value
     */
    public int cutting(int[] prices, int n) {
        // Write your code here
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] + prices[i - j - 1]);
            }
        }
        return dp[n];
    }
}
