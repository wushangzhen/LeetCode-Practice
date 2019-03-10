class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int n = A.length;
        if (n == 0) {
            return A;
        }
        int m = A[0].length;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left < right) {
                int temp = A[i][left];
                A[i][left] = A[i][right];
                A[i][right] = temp;
                left++;
                right--;
            }
            left = 0;
            for (; left < m; left++) {
                A[i][left] = 1 - A[i][left];
            }
        }
        return A;
    }
}
