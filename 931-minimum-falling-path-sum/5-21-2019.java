class Solution {
    public int minFallingPathSum(int[][] A) {
        // modify the original matrix
        int n = A.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int best = A[i - 1][j];
                if (j != 0) {
                    best = Math.min(A[i - 1][j - 1], best);
                }
                if (j != n - 1) {
                    best = Math.min(A[i - 1][j + 1], best);
                }
                A[i][j] += best;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(A[n - 1][i], min);
        }
        return min;
    }
}
