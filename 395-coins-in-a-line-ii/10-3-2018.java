public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        int n = values.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            sum[i] = sum[i -  1] + values[n - i];

        int[] dp = new int[n + 1];
        dp[1] = values[n - 1];
        for (int i = 2; i <= n; ++i)
            dp[i] = Math.max(sum[i] - dp[i - 1], sum[i] - dp[i - 2]);
            
        return dp[n]  > sum[n] / 2;
    }
}
