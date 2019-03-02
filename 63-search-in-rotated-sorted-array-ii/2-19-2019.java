class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0;
        int n = nums.length;
        int right = n - 1;
        int pivot = nums[0];
        while (left + 1 < right) {
            if (nums[left] == nums[right]) {
                if (nums[right] == target) {
                    return true;
                }
                right--; // 注意一定是要求右边的不能与pivot相等，不要更改pivotc
                continue;
            }
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                if (nums[mid] < pivot && target >= pivot) {
                    right = mid;
                } else {
                    left = mid;
                }
            } else {
                if (nums[mid] >= pivot && target < pivot) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        if (nums[left] == target) {
            return true;
        }
        if (nums[right] == target) {
            return true;
        }
        return false;
    }
}
