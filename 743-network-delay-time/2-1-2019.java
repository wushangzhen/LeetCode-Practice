class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[K - 1] = 0;
        for (int i = 0; i < N - 1; i++) {
            for (int[] time : times) {
                if (dp[time[0] - 1] != Integer.MAX_VALUE) {
                    dp[time[1] - 1] = Math.min(dp[time[1] - 1], dp[time[0] - 1] + time[2]);
                }
            }
        }
        int res = -1;
        for (int i : dp) {
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, i);
        }
        return res;
    }
}
