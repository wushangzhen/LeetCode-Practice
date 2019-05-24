class Solution {
    public double knightProbability(int N, int K, int sr, int sc) {
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        double[][] dp = new double[N][N];
        dp[sr][sc] = 1;
        for (int i = 0; i < K; i++) {
            double[][] dp1 = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int k = 0; k < 8; k++) {
                        int tr = r + dx[k];
                        int tc = c + dy[k];
                        if (tr < 0 || tr >= N || tc < 0 || tc >= N) {
                            continue;
                        }
                        dp1[tr][tc] += dp[r][c] / 8.0;
                    }
                }
            }
            dp = dp1;
        }
        double ans = 0;
        for (double[] row : dp) {
            for (double i : row) {
                ans += i;
            }
        }
        return ans;
    }
}
