public class Solution {
    /**
     * @param costs: n x 3 cost matrix
     * @return: An integer, the minimum cost to paint all houses
     */
    public int minCost(int[][] costs) {
        // write your code here
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int n = costs.length;
        int m = costs[0].length;
        if (m == 0) {
            return 0;
        }
        int old, now = 0;
        int[][] f = new int[2][3];
        f[now][0] = f[now][1] = f[now][2] = 0;
        for (int i = 1; i <= n; i++) {
            old = now;
            now = 1 - now;
            for (int j = 0; j < m; j++) {
                f[now][j] = Integer.MAX_VALUE;
                for (int k = 0; k < 3; ++k) {
                    if (k != j && f[old][k] + costs[i - 1][j] < f[now][j]) {
                        f[now][j] = f[old][k] + costs[i - 1][j];
                    }
                }
            }
        }
        int res = f[now][0];
        if (f[now][1] < res) {
            res = f[now][1];
        }
        if (f[now][2] < res) {
            res = f[now][2];
        }
        return res;
    }
}
