public class Solution {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if (triangle == null || triangle.length == 0) {
            return 0;
        }
        int n = triangle.length;
        int m = triangle[n - 1].length;
        int[][] f = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                f[i][0] = f[i][i] = triangle[0][0];
                continue;
            }
            f[i][0] = triangle[i][0] + f[i - 1][0];
            f[i][i] = triangle[i][i] + f[i - 1][i - 1];
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j] + triangle[i][j], f[i - 1][j - 1] + triangle[i][j]);
            }
        }
        int min = f[n - 1][0];
        for (int i = 1; i < triangle[n - 1].length; i++) {
            if (min > f[n - 1][i]) {
                min = f[n - 1][i];
            }
        }
        return min;
    }
}
