public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        char[][] memo = new char[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    memo[i][j] = '1';
                } else {
                    memo[i][j] = '2';
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    if (dp[i][j] < dp[i - 1][j - 1] + 1) {
                        memo[i][j] = '0';
                    }
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (memo[i][j] == '0') {
                System.out.println(A.charAt(i - 1));
                i--;
                j--;
            } else if (memo[i][j] == '1') {
                j--;
            } else {
                i--;
            }
        }
        return dp[n][m];
    }
}
