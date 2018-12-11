class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]); // 保证所有的dp值是算过的
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = Math.max(dp[j + 1][i - 1] + 2, dp[i][j]);
                }  
            }
        }
        return dp[0][n - 1];
    }
}
