class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        int[][] dp = new int[2][m + 1];
        int max = 0;
        int now = 0;
        int old = 0;
        for (int i = 0; i <= n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    dp[now][j] = 0;
                } else {
                    if (A[i - 1] == B[j - 1]) {
                        dp[now][j] = dp[old][j - 1] + 1;
                        max = Math.max(dp[now][j], max);
                    } else {
                        dp[now][j] = 0;
                    }
                }  
            }
        }
        return max;
        
    }
}
