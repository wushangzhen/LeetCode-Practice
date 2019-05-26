class Solution {
    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return helper(0, n - 1, 0, dp, boxes);
    }
    int helper(int start, int end, int k, int[][][] dp, int[] boxes) {
        if (start > end) {
            return 0;
        }
        if (dp[start][end][k] > 0) {
            return dp[start][end][k];
        }
        for (; start + 1 <= end; start++) {
            if (boxes[start + 1] == boxes[start]) {
                k++;
            } else {
                break;
            }
        }
        int temp = (k + 1) * (k + 1) + helper(start + 1, end, 0, dp, boxes);
        for (int j = start + 1; j <= end; j++) {
            if (boxes[j] == boxes[start]) {
                temp = Math.max(temp, helper(start + 1, j - 1, 0, dp, boxes) + helper(j, end, k + 1, dp, boxes));
            }
        }
        dp[start][end][k] = temp;
        return temp;
    }
}
