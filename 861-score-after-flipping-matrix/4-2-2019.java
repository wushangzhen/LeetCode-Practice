class Solution {
    public int matrixScore(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int res = n * (1 << (m - 1));
        for (int j = 1; j < m; j++) {
            int cur = 0;
            for (int i = 0; i < n; i++) {
                cur += (A[i][j] == A[i][0]) ? 1 : 0;
            }
            res += Math.max(cur, n - cur) * (1 << (m - 1 - j));
        }
        return res;
    }
}
