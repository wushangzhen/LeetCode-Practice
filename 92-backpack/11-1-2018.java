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
        boolean[][] dp = new boolean[2][m + 1]; 
        int now = 0;
        int old = 0;
        dp[now][0] = true;
        for (int i = 1; i <= n; i++) {
            old = now;
            now = 1 - old;
            for (int j = 0; j < m + 1; j++) {
                dp[now][j] = dp[old][j];
                if (j >= A[i - 1] && dp[old][j - A[i - 1]]) {
                    dp[now][j] = true;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[now][i]) {
                return i;
            }
        }
        return 0;
    }
}
