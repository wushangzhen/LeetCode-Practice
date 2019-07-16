class A8 {
    boolean function(int[] arr, int t, int K) {
        boolean[][] dp = new boolean[t + 1][K + 1];
        dp[0][0] = true;
        for (int i = 1; i <= t; i++) {
            for (int k = 1; k <= K; k++) {
                dp[i][k] = dp[i][k - 1];
                for (int j = 0; j < arr.length; j++) {
                    if (i >= arr[j] && dp[i - arr[j][k - 1]) {
                        dp[i][k] = true;
                    }
                }
            }
        }
        return dp[t][K];
    }
}
