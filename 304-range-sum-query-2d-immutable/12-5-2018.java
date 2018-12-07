class NumMatrix {
    int[][] matrix;
    int n;
    int m;
    int[][] C;
    public int lowbit(int x) {
        return x & -x;
    }
    public void add(int x, int y, int val) {
        for (int i = x + 1; i <= n; i += lowbit(i)) {
            for (int j = y + 1; j <= m; j += lowbit(j)) {
                C[i][j] += val;
            }
        } 
    }
    public int sum(int x, int y) {
        int res = 0;
        for (int i = x + 1; i > 0; i -= lowbit(i)) {
            for (int j = y + 1; j > 0; j -= lowbit(j)) {
                res += C[i][j];
            }
        }
        return res;
    }
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.n = matrix.length;
        if (n != 0)
            this.m = matrix[0].length;
        this.C = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                add(i, j, matrix[i][j]);
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum(row2, col2) - sum(row2, col1 - 1) - sum(row1 - 1, col2) + sum(row1 - 1, col1 - 1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
