class Solution {
    public int missingElement(int[] nums, int k) {
        int missing = 0;
        int n = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (missing + nums[i] - nums[i - 1] - 1 >= k) {
                int count = k - missing;
                return nums[i - 1] + count;
            }
            missing += nums[i] - nums[i - 1] - 1;
        }
        return nums[n - 1] + k - missing;
    }
}
