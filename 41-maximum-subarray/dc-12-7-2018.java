class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return helper(0, nums.length - 1, nums);
    }
    int helper(int start, int end, int[] nums) {
        if (start >= end) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        int lmax = helper(start, mid - 1, nums);
        int rmax = helper(mid + 1, end, nums);
        int mmax = nums[mid];
        int t = mmax;
        for (int i = mid - 1; i >= start; i--) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        t = mmax;
        for (int i = mid + 1; i <= end; i++) {
            t += nums[i];
            mmax = Math.max(mmax, t);
        }
        return Math.max(mmax, Math.max(lmax, rmax));
    }
}
