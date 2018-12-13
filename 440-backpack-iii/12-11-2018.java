public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        if (A == null || A.length == 0 || m == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            dp[i] = 0;
            for (int j = 0; j < n; j++) {
                if (i >= A[j]) {
                    dp[i] = Math.max(dp[i], dp[i - A[j]] + V[j]);
                }
            }
        }
        while (m != 0) {
            if (dp[m] != 0) {
                return dp[m];
            }
            m--;
        }
        return dp[m];
    }
}
