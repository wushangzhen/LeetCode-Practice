class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int left = 0;
        int right = 0;
        int n = nums.length;
        while (right < n) {
            if (right != 0 && nums[right] > nums[right - 1]) {
                
            } else {
                max = Math.max(right - left, max);
                left = right;
            }
            right++;
        }
        max = Math.max(right - left, max);
        return max;
    }
}
