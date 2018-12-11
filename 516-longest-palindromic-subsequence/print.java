class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        
        String[][] memo = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = "";
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            memo[i][i] = String.valueOf(s.charAt(i));
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i] <= dp[j][i - 1]) {
                    memo[j][i] = memo[j][i - 1];
                    dp[j][i] = dp[j][i - 1];
                }
                if (dp[j + 1][i] > dp[j][i]) {
                    memo[j][i] = memo[j + 1][i];
                    dp[j][i] = dp[j + 1][i];
                }
                dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]); // 保证所有的dp值是算过的
                if (s.charAt(i) == s.charAt(j)) {
                    if (dp[j + 1][i - 1] + 2 > dp[j][i]) {
                        memo[j][i] = s.charAt(i) + memo[j + 1][i - 1] + s.charAt(i);
                    }
                    dp[j][i] = Math.max(dp[j + 1][i - 1] + 2, dp[j][i]);
                }  
            }
        }
        System.out.println(memo[0][n - 1]);
        return dp[0][n - 1];
    }
}
