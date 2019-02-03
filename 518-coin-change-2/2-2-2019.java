class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        // 为了避免重复，要设置前i种商品拼成的重量，即二维数组
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                if (j - coins[i - 1] >= 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j]; // 这个很重要，不能忘掉
                }
            }
        }
        return dp[n][amount];
    }
}
