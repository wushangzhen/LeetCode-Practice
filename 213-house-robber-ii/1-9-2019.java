class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1)); 
    }
    int helper(int[] nums, int start, int end) {
        int n = end - start + 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[start + i - 1]);
        }
        return dp[n];
    }
}
