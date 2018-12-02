public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
        // write your code here
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int[][] colSum = getColSum(matrix, n, m);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] array = compress(colSum, i, j);
                max = Math.max(maxSubarray(array), max);
            }
        }
        return max;
    }
    int maxSubarray(int[] num) {
        int sum = 0;
        int min = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            max = Math.max(max, sum - min);
            min = Math.min(min, sum);
        }
        return max;
        
    }
    int[][] getColSum(int[][] matrix, int n, int m) {
        int[][] colSum = new int[n + 1][m];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j <= n; j++) {
                colSum[j][i] = colSum[j - 1][i] + matrix[j - 1][i];
            }
        }
        return colSum;
    }
    int[] compress(int[][] colSum, int up, int down) {
        int[] res = new int[colSum[0].length];
        for (int i = 0; i < colSum[0].length; i++) {
            res[i] = colSum[down + 1][i] - colSum[up][i];
        }
        return res;
    }
}
