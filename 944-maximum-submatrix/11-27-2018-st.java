public class Solution {
    /**
     * @param matrix: the given matrix
     * @return: the largest possible sum
     */
    public int maxSubmatrix(int[][] matrix) {
       // corner cases
       if (matrix == null || matrix.length == 0) {
           return 0;
       }
       
       if (matrix[0].length == 0) {
           return 0;
       }
       
       int m = matrix.length;
       int n = matrix[0].length;
       int[][] colSum = new int[m + 1][n];
       getColSum(matrix, colSum);
       int maxSum = Integer.MIN_VALUE;
       
       for (int up = 0; up < m; up++) {
           for (int down = up; down < m; down++) {  //!!
               int[] compression = compress(colSum, up, down);
               maxSum = Math.max(maxSum, maxSubArray(compression));
           }
       }
       
       return maxSum;
    }
    
    private int maxSubArray(int[] nums) {
        int min = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - min);
            min = Math.min(min, sum);
        }
        
        return maxSum;
    }
    
    private int[] compress(int[][] colSum, int up, int down) {
        int[] res = new int[colSum[0].length];
        
        for (int i = 0; i < res.length; i++) {
            res[i] = colSum[down + 1][i] - colSum[up][i]; 
        }
        
        return res;
    }
    
    private void getColSum(int[][] matrix, int[][] colSum) {
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                colSum[i][j] = colSum[i - 1][j] + matrix[i - 1][j];
            }
        }
    }
}
