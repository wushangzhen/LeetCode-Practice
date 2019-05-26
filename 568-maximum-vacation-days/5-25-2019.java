class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int K = days[0].length;
        int N = flights.length;
        int[][] dp = new int[K + 1][N];
        for (int[] d : dp) {
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (dp[i - 1][k] != Integer.MIN_VALUE && (j == k || flights[k][j] == 1)) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + days[j][i - 1]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(dp[K][i], max);
        }
        return max;
    }
}
