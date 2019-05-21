class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int[] dp = new int[N]; // the maximum value so far as the ending of this elements
        for (int i = 0; i < N; i++) {
            int curMax = 0;
            for (int k = 1; k <= K && i - k + 1 >= 0; k++) {
                curMax = Math.max(curMax, A[i - k + 1]); // update the curMax find the maximum value so far
                dp[i] = Math.max(dp[i], (i < k ? 0 : dp[i - k]) + curMax * k); // update the dp[i]
            }
        }
        return dp[N - 1];
    }
}
