class Solution {
    // [4,5,6,7,0,1,2]
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int pivot = nums[start];
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (pivot <= target && nums[mid] < pivot) {
                    end = mid;
                } else {
                    start = mid;
                }
            }
            if (nums[mid] > target) {
                if (pivot > target && nums[mid] >= pivot) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target) {
            return start;
        } 
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
