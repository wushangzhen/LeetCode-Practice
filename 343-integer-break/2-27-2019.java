class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                dp[i] = Math.max(dp[i], Math.max((i - j), dp[i - j]) * Math.max(j, dp[j]));
            }
        }
        return dp[n];
    }
}
