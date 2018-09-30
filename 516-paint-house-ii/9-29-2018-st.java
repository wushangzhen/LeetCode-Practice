public class Solution {
    /**
     * @param costs: n x k cost matrix
     * @return: an integer, the minimum cost to paint all houses
     */
    public int minCostII(int[][] C) {
        // write your code here
        int n = C.length;
        if (n == 0) {
            return 0;
        }
        int K = C[0].length;
        if (K == 0) {
            return 0;
        }
        int[][] f = new int[n + 1][K];
        int i, j, k, a, b;
        for (i = 0; i < K; ++i) {
            f[0][i] = 0;
        }
        // find the minimum and 2nd minimum
        for (i = 1; i <= n; ++i) {
            a = b = -1;
            for (k = 0; k < K; ++k) {
                if (a == -1 || f[i - 1][k] < f[i - 1][a]) {
                    b = a;
                    a = k;
                } else {
                    if (b == -1 || f[i - 1][k] < f[i - 1][b]) {
                        b = k;
                    }
                }
            }
            for (j = 0; j < k; ++j) {
                if (j != a) {
                    f[i][j] = f[i - 1][a] + C[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][b] + C[i - 1][j];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        k = 0;
        for (j = 0; j < K; ++j) {
            res = Math.min(res, f[n][j]);
            //if (res == f[n][j]) {
            //    k = j;
            //}
        }
        return res;
    }
}
