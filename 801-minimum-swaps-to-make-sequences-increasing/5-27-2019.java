class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < 2; j++) {
                if (j == 0) { // last position we didn't swap
                    if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) { // invalid should swap
                        if (B[i] > A[i - 1] && A[i] > B[i - 1] && dp[i - 1][j] != Integer.MAX_VALUE) {
                            dp[i][1] = Math.min(dp[i - 1][j] + 1, dp[i][1]);
                        }
                    } else { // valid 
                        if (B[i] > A[i - 1] && A[i] > B[i - 1] && dp[i - 1][j] != Integer.MAX_VALUE) {
                            dp[i][1] = Math.min(dp[i - 1][j] + 1, dp[i][1]);
                        }
                        dp[i][0] = Math.min(dp[i - 1][j], dp[i][0]);
                    }
                } else { // last position we swap
                    if (A[i] <= B[i - 1] || B[i] <= A[i - 1]) {
                        if (B[i - 1] < B[i] && A[i - 1] < A[i] && dp[i - 1][j] != Integer.MAX_VALUE) {
                            dp[i][1] = Math.min(dp[i - 1][j] + 1, dp[i][1]);
                        }
                    } else { // valid
                        if (B[i - 1] < B[i] && A[i - 1] < A[i] && dp[i - 1][j] != Integer.MAX_VALUE) {
                            dp[i][1] = Math.min(dp[i - 1][j] + 1, dp[i][1]);
                        }
                        dp[i][0] = Math.min(dp[i - 1][j], dp[i][0]);
                    }
                }
            }
        }
        return dp[n - 1][0] > dp[n - 1][1] ? dp[n - 1][1] : dp[n - 1][0];
    }
}
