class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += nums[i - 1];
            preSum[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] >= s) {
                    min = Math.min(min, i - j);
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
