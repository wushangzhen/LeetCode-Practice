class Solution {
    //[4,5,6,7,0,1,2]
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int pivot = nums[0];
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                if (pivot <= target && nums[mid] < pivot) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (pivot > target && nums[mid] >= pivot) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
