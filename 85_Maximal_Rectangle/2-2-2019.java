class Solution {
    public int maximalRectangle(char[][] matrix) {
        // 这个题需要降维来解，用84题的方法，每一行进行计算，累计一下进行直方图的计算
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }
        int[] dp = new int[m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[j] = (matrix[i][j] == '0') ? 0 : dp[j] + 1;
            }
            max = Math.max(max, helper(dp));
        }
        return max;
    }
    public int helper(int[] dp) {
        Stack<Integer> stk = new Stack<>();
        int n = dp.length;
        int max = 0;
        for (int i = 0; i <= n; i++) {
            int cur = (i == n) ? -1 : dp[i];
            while (!stk.isEmpty() && cur <= dp[stk.peek()]) {
                int h = dp[stk.pop()];
                int w = stk.isEmpty() ? i : i - stk.peek() - 1;
                max = Math.max(max, h * w);
            }
            stk.push(i);
        }
        return max;
    }
}
