class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = temp[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            temp[i + 1] = nums[i];
        }
        Integer[][] memo = new Integer[n + 2][n + 2];
        return helper(0, n + 1, temp, memo);
    }
    int helper(int left, int right, int[] temp, Integer[][] memo) {
        if (left + 1 >= right) {
            return 0;
        }
        if (memo[left][right] != null) {
            return memo[left][right];
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, temp[i] * temp[left] * temp[right] + helper(left, i, temp, memo) + helper(i, right, temp, memo));
        }
        return memo[left][right] = ans;
    }
}
