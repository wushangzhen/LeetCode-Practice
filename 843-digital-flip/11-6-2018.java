public class Solution {
    /**
     * @param nums: the array
     * @return: the minimum times to flip digit
     */
    public int flipDigit(int[] nums) {
        // Write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int t = 0;
                if (nums[i - 1] != j) {
                    t++;
                }
                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][1] + t, dp[i][j]);
                    continue;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][0] + t, dp[i][j]);
                    dp[i][j] = Math.min(dp[i - 1][1] + t, dp[i][j]);
                }
            }
        }
        return Math.min(dp[n][1], dp[n][0]);
    }
}
