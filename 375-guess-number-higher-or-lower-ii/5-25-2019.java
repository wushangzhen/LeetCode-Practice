class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return helper(1, n, dp);
    }
    int helper(int l, int r, int[][] dp) {
        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            res = Math.min(res, i + Math.max(helper(l, i - 1, dp), helper(i + 1, r, dp))); // assuming you choose is always bad
        }
        dp[l][r] = res;
        return res;
    }
}
