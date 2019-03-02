class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        dp[0] = 0;
        int res = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j > 0; j--) {
                if (envelopes[j - 1][0] < envelopes[i - 1][0]
                   && envelopes[j - 1][1] < envelopes[i - 1][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
