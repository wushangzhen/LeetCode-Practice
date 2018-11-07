public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (m == 0 || A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if ((j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]) || dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        for (int j = m; j >= 0; j--) {
            if (dp[n][j]) {
                return j;
            }
        }
        return 0;
    }
}
