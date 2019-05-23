class Solution {
    public int countTriplets(int[] A) {
        int N = 1 << 16;
        int m = 3;
        int[][] dp = new int[m + 1][N];
        dp[0][N - 1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int k = 0; k < N; k++) {
                for (int a : A) {
                    dp[i][k & a] += dp[i - 1][k];
                }
            }
        }
        return dp[m][0];
    }
}
