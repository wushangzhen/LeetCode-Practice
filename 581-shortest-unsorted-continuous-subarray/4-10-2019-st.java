class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int end = -2, beg = -1;
        int max = nums[0];
        int min = nums[nums.length - 1];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[n - 1 - i], min);
            if (max > nums[i]) {
                end = i;
            }
            if (min < nums[n - 1 - i]) {
                beg = n - 1 - i;
            }
        }
        return end - beg + 1;
    }
}
