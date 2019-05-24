class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] memo = new double[n + 1][K + 1];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A[i];
            memo[i + 1][1] = sum / (i + 1);
        }
        return helper(n, K, memo, A);
    }
    double helper(int n, int k, double[][] memo, int[] A) {
        if (memo[n][k] != 0) {
            return memo[n][k];
        }
        if (n < k) {
            return 0;
        }
        double sum = 0;
        for (int i = n; i > 0; i--) {
            sum += A[i - 1];
            memo[n][k] = Math.max(memo[n][k], helper(i - 1, k - 1, memo, A) + sum / (n - i + 1));
        }
        return memo[n][k];
    }
    
}
