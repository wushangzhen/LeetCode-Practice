class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) {
            return -1;
        }
        int n = nums.length;
        return helper(0, n - 1, nums, k - 1);
    }
    int helper(int start, int end, int[] nums, int index) {
        if (start >= end) {
            return nums[start];
        }
        int l = start;
        int r = end;
        int mid = (l + r) / 2;
        int pivot = nums[mid]; // necessary do not use nums[mid] because it can be changed
        while (l <= r) {
            while (l <= r && nums[l] > pivot) {
                l++;
            }
            while (l <= r && nums[r] < pivot) {
                r--;
            }
            if (l <= r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r--;
            }
        }
        if (index <= r) {
            return helper(start, r, nums, index);
        }
        if (l <= index) {
            return helper(l, end, nums, index);
        }
        return nums[index];
    }
}
