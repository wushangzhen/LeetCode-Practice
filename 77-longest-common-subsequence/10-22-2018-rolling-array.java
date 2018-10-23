public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: The length of longest common subsequence of A and B
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m + 1];
        int res = 0;
        int now = 0;
        int old = 0;
        for (int i = 0; i <= n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[now][j] = 0;
                    continue;
                }
                dp[now][j] = Math.max(dp[old][j], dp[now][j - 1]);
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[now][j] = Math.max(dp[old][j - 1] + 1, dp[now][j]);
                }
                res = Math.max(dp[now][j], res);
            }
        }
        return res;
    }
}
