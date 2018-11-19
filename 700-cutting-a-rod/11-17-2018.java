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
        int[] s = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (dp[j] + prices[i - j - 1] > dp[i]) {
                    dp[i] = dp[j] + prices[i - j - 1];
                    s[i] = j;
                }
                //dp[i] = Math.max(dp[i], dp[j] + prices[i - j - 1]);
            }
        }
        int k = n;
        while (k != 0) {
            System.out.println(s[k]);
            k = s[k];
        }
        return dp[n];
    }
}
