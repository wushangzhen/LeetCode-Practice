public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        int res = Integer.MIN_VALUE;
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m + 1]; // A[i - 1] and b[j - 1] as ending's LCS
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
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[now][j] = dp[old][j - 1] + 1;
                    res = Math.max(dp[now][j], res);
                } else {
                    dp[now][j] = 0; // this is necessary because we have to set the value to zero now will be other value;
                }
            }
        }
        return res;
    }
}
