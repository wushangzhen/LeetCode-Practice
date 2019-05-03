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
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[2][m];
        // rolling array 优化空间复杂度至O(m);
        int old = 0;
        int now = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < m; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[now][j] = 1;
                    } else {
                        dp[now][j] = dp[old][j - 1] + 1;
                    }
                } else {
                    dp[now][j] = 0; // 必须的，因为之前dp[now]里面有值的
                }
                max = Math.max(dp[now][j], max);
            }
        }
        return max;
    }
}
