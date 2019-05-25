class Solution {
    public int knightDialer(int N) {
        int MOD = 1_000_000_007;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(i * 3 + j);
            }
        }
        set.add(3 * 3 + 1);
        long[][] dp = new long[N + 1][11];
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
        Arrays.fill(dp[1], 1);
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 11; j++) {
                if (set.contains(j)) {
                    int x = j / 3;
                    int y = j % 3;
                    for (int k = 0; k < 8; k++) {
                        int ox = x + dx[k];
                        int oy = y + dy[k];
                        if (set.contains(ox * 3 + oy) && (ox >= 0 && ox < 3 && oy >= 0 && oy < 3) || (ox == 3 && oy == 1)) {
                            dp[i][j] += dp[i - 1][ox * 3 + oy];
                            dp[i][j] %= MOD;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int j = 0; j < 11; j++) {
            if (set.contains(j)) {
                ans += dp[N][j];
                ans %= MOD;
            }
        }
        return ans;
    }
}
