class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int start = 0; 
        int end = n - 1;
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        int pivot = nums[start];
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid - 1] < nums[mid]) {
                if (nums[mid] > pivot) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
        }
        return nums[start] < nums[end] ? nums[start] : nums[end];
    }
}
