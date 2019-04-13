class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0; 
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        int n = nums.length;
        boolean[][] dp = new boolean[2][sum + 1];
        int now = 0;
        int old = 1;
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            old = now;
            now = 1 - now;
            dp[now][0] = true;
            for (int j = 0; j <= sum; j++) {
                dp[now][j] = dp[old][j];
                if (j >= nums[i - 1]) {
                    dp[now][j] = dp[now][j] || dp[old][j - nums[i - 1]];
                }
            }
        }
        return dp[now][sum];
    }
}
