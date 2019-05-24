class Solution {
    public int numPermsDISequence(String S) {
        int MOD = 1_000_000_007;
        int N = S.length();
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'I') {
                for (int j = 0, cur = 0; j < N - i; j++) { // so hard to understand
                    dp[i + 1][j] = cur = (cur + dp[i][j]) % MOD;
                }
            } else {
                for (int j = N - i - 1, cur = 0; j >= 0; j--) {
                    dp[i + 1][j] = cur = (cur + dp[i][j + 1]) % MOD;
                }
            }
        }
        return dp[N][0];
    }
}
