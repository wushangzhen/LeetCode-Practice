public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int end = 0;
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[m + 1][n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[j][i] = 0;
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[j][i] = Math.max(dp[j - 1][i - 1] + 1, dp[j][i]);
                }
                max = Math.max(dp[j][i], max);
            }
        }
        return max;
    }
}
