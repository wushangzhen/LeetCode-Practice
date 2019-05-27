class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i != 0 && s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = 1;
            } else if (i != 0) {
                dp[i - 1][i] = 2;
            }
        }
        for (int len = 1; len <= n; len++) {
            for (int start = 0; start + len <= n; start++) {
                dp[start][start + len - 1] = len;
                for (int k = start; k < start + len - 1; k++) {
                    int temp = dp[start][k] + dp[k + 1][start + len - 1];
                    dp[start][start + len - 1] = Math.min(s.charAt(start + len - 1) == s.charAt(k) ? temp - 1 : temp, dp[start][start + len - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
