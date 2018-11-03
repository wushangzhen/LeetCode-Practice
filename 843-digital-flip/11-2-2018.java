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
        dp[0][0] = 0;
        dp[0][1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int t = 0;
                if (nums[i - 1] != j) {
                    t++;
                }
                for (int k = 0; k < 2; k++) {
                    if (k == 0 && j == 1) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i - 1][k] + t, dp[i][j]);
                }
            }
        }
        return Math.min(dp[n][0], dp[n][1]);
    }
}
