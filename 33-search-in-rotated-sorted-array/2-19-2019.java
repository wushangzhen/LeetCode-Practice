class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 4,5,6,7,0,1,2
        int pivot = nums[0];
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } 
            if (nums[mid] < target) {
                if (target >= pivot && nums[mid] < pivot) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            if (nums[mid] > target) {
                if (target < pivot && nums[mid] >= pivot) {
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
