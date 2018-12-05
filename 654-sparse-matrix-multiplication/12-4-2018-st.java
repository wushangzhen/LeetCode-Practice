class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n1 = A.length;
        int n2 = A[0].length;
        int n3 = B.length;
        int n4 = B[0].length;
        int[][] result = new int[n1][n4];
        for (int i = 0; i < n1; i++) {
            for (int k = 0; k < n2; k++) {
                int sum = 0;
                if (A[i][k] != 0) {
                    for (int j = 0; j < n4; j++) {
                        if (B[k][j] != 0) {
                            result[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
            }
        }
        return result;
    }
}
