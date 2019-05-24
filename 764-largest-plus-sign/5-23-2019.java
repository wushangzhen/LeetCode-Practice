class Solution {
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(mine[0] * N + mine[1]);
        }
        int[][] dp = new int[N][N];
        int count = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            count = 0;
            for (int j = 0; j < N; j++) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = count;
            }
            count = 0;
            for (int j = N - 1; j >= 0; j--) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int j = 0; j < N; j++) {
            count = 0;
            for (int i = 0; i < N; i++) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int i = N - 1; i >= 0; i--) {
                count = set.contains(i * N + j) ? 0 : count + 1;
                dp[i][j] = Math.min(dp[i][j], count);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
