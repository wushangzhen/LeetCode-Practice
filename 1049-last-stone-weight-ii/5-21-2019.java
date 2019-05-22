class Solution {
    public int lastStoneWeightII(int[] stones) {
        int S = 0, S2 = 0;
        for (int stone : stones) {
            S += stone;
        }
        int n = stones.length;
        boolean[][] dp = new boolean[n + 1][S / 2 + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        int max = 0;
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i <= S / 2; i++) {
                if (dp[j - 1][i] || (i >= stones[j - 1] && dp[j - 1][i - stones[j - 1]])) {
                    dp[j][i] = true;
                    max = Math.max(i, max);
                }
            }
        }
        return S - max * 2;
    }
}
