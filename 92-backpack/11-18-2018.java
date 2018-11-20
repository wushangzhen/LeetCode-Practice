public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if (A == null || A.length == 0 || m <= 0) {
            return 0;
        }
        boolean[][] dp = new boolean[A.length + 1][m + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= m; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = false;
                    continue;
                }
                if ((j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]) || dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }
        int res = 0;
        for (int i = m; i >= 0; i--) {
            if (dp[A.length][i]) {
                res = i;
                break;
            }
        }
        return res;
    }
}
