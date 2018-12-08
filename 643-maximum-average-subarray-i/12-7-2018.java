class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return 0.0;
        }
        int left = 0;
        int right = 0;
        int n = nums.length;
        double result = 0;
        for (; right < k; right++) {
            result += nums[right];
        }
        double res = Integer.MIN_VALUE;
        while (right < n) {
            res = Math.max(res, result / k);
            result += nums[right++];
            result -= nums[left++];
        }
        res = Math.max(res, result / k);
        return res;
    }
}
