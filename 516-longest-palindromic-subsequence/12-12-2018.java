public class Solution {
    /**
     * @param s: the maximum length of s is 1000
     * @return: the longest palindromic subsequence's length
     */
    public int longestPalindromeSubseq(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(dp[j][i - 1], dp[j + 1][i]);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = Math.max(dp[j][i], dp[j + 1][i - 1] + 2);
                }
            }
        }
        return dp[0][n - 1];
    }
}
