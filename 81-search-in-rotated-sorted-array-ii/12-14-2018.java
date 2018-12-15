class Solution {
    // [2,5,6,0,0,1,2]
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int pivot = nums[0];
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            } 
            if (nums[mid] == nums[start]) {
                start++;
                continue;
            }
            if (nums[mid] == nums[end]) {
                end--;
                continue;
            }
            if (nums[mid] < target) {
                // start = mid;
                if (nums[mid] < nums[start] && target >= pivot && nums[mid] <= pivot) {
                    end = mid;
                } else { 
                    start = mid;
                }
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[start] && target < pivot && nums[mid] >= pivot) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        } 
        return false;
    }
}
