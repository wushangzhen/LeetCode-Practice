class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int l = 0;
        int r = n - 1;
        while (l + 1 < r) {
            while (l + 1 < r && nums[l] == nums[r]) {
                l++;
            }
            if (nums[l] == target) {
                return true;
            }
            if (nums[r] == target) {
                return true;
            }
            if (l + 1 < r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[mid] < target && nums[mid] < nums[r] && target > nums[r] && nums[l] > nums[r]) {
                    r = mid;
                } else if (nums[mid] > target && nums[mid] > nums[r] && target < nums[r] && nums[l] > nums[r]) {
                    l = mid;
                } else if (nums[mid] < target) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
        }
        if (nums[l] == target || nums[r] == target) {
            return true;
        }
        return false;
    }
}
