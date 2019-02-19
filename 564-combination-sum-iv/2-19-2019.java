class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i <= n; i++) {
                if (j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if (i == 0) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) { // this is necessary
                    dp[i][j] += dp[n][j - nums[i - 1]]; // should be n, others after this value will affect the results
                }
            }
        }
        return dp[n][target];
    }
}
