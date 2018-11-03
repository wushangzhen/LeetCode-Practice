public class Solution {
    /**
     * @param A: An array of Integer
     * @return: an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = 0;
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i == 0) {
                max = Math.max(max, dp[i]);
                continue;
            }
            if (A[i] > A[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } 
            max = Math.max(dp[i], max);
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            if (i == n - 1) {
                max = Math.max(max, dp[i]);
                continue;
            }
            if (A[i] > A[i + 1]) {
                dp[i] = dp[i + 1] + 1;
            } 
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
