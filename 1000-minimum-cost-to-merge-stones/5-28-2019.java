class Solution {
    public int mergeStones(int[] stones, int K) {
        int len = stones.length;
        if ((len - 1) % (K - 1) != 0) {
            return -1;
        }
        int i, j, k, l, t;
        int[] preSum = new int[len + 1];
        for (i = 1; i <= len; i++) {
            preSum[i] = preSum[i - 1] + stones[i - 1];
        }
        int[][][] dp = new int[len + 1][len + 1][K + 1];
        int max = 99999999;
        for (i = 1; i <= len; i++) {
            for (j = 1; j <= len; j++) {
                for (k = 1; k <= K; k++) {
                    dp[i][j][k] = max;
                }
            }
        }
        for (i = 1; i <= len; i++) {
            dp[i][i][1] = 0;
        }
        for (l = 2; l <= len; l++) {
            for (i = 1; i <= len - l + 1; i++) {
                j = i + l - 1;
                for (k = 2; k <= K; k++) {
                    for (t = i; t < j; t++) {
                        dp[i][j][k] = Math.min(dp[i][j][k], 
                                              dp[i][t][k - 1] + dp[t + 1][j][1]);
                    }
                }
                dp[i][j][1] = dp[i][j][K] + preSum[j] - preSum[i - 1];
            }
        }
        return dp[1][len][1];
    }
}
