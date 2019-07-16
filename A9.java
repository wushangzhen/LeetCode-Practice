class A9 {
    boolean function(int[] arr, int t) {
        boolean[] dp = new boolean[t + 1];
        dp[0] = true;
        for (int i = 1; i <= t; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i >= arr[j] && dp[i - arr[j]) {
                    dp[i] = true;
                }
            }
        }
        return dp[t];
    }
}
