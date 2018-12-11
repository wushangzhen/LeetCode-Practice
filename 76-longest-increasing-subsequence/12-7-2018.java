class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        int[] memo = new int[n];
        for (int i = 0; i < n; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        int maxIndex = 0;
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[j] + 1 > dp[i]) {
                        memo[i] = j;
                    }
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    if (dp[i] > max) {
                        maxIndex = i;
                    }
                    max = Math.max(dp[i], max);
                    
                }
            }
        }
        int temp = maxIndex;
        while (memo[temp] != Integer.MAX_VALUE) {
            System.out.println(nums[temp]);
            temp = memo[temp];
        }
        System.out.println(nums[temp]);
        return max;
    }
}
