class Solution {
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        int mod = 1_000_000_007;
        int n = group.length;
        int[][] dp = new int[P + 1][G + 1];
        dp[0][0] = 1;
        for (int k = 0; k < n; k++) {
            int p = profit[k];
            int g = group[k];
            for (int i = P; i >= 0; i--) {
                for (int j = G; j >= 0; j--) {
                    if (j + g <= G) {
                        if (p + i >= P) {
                            dp[P][j + g] = (dp[P][j + g] + dp[i][j]) % mod;
                        } else {
                            dp[p + i][j + g] = (dp[p + i][j + g] + dp[i][j]) % mod;
                        }
                    }
                }
            }
        }
        int sum = 0;
        for (int i = G; i >= 0; i--) {
            sum = (sum + dp[P][i]) % mod;
        }
        return sum;
    }
}
