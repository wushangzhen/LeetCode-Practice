class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
        }
        return nums[right] > nums[left] ? right : left;
    }
}
