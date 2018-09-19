public class Solution {
    /**
     * @param A: a sparse matrix
     * @param B: a sparse matrix
     * @return: the result of A * B
     */
    public int[][] multiply(int[][] A, int[][] B) {
        // write your code here
        if (A == null || B == null) {
            return null;
        } 
        int nA = A.length;
        int mA = A[0].length;
        int nB = B.length;
        int mB = B[0].length;
        int [][] result = new int[nA][mB];
        for (int i = 0; i < nA; i++) {
            for (int k = 0; k < mB; k++) {
                int sum = 0;
                for (int j = 0; j < nB; j++) {
                   sum += A[i][j] * B[j][k]; 
                }
                result[i][k] = sum;
            }
        }
        return result;
    }
}
