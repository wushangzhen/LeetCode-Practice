class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    int helper(int[] nums, int left, int right) {
        if (left >= right) {
            return nums[left];
        }
        int p = (left + right) / 2;
        int l = helper(nums, left, p);
        int r = helper(nums, p + 1, right);
        int c = crossSum(nums, left, right, p);
        return Math.max(c, Math.max(l, r));
    }
    int crossSum(int[] nums, int left, int right, int p) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = p; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = p + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }
        return leftSum + rightSum;
    }
}
