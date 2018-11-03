public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        // write your code here
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }
        int n = coins.length;
        int[] dp = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[i] = 0;
                    continue;
                }
                if (i - coins[j] < 0 || dp[i - coins[j]] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
