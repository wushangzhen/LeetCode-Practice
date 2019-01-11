class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, k - 1);
    }
    public int quickSelect(int[] nums, int start, int end, int kth) {
        if (start >= end) {
            return nums[start];
        }
        int left = start, right = end;
        int mid = (start + end) / 2;
        int pivot = nums[mid];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }
            while (left <= right && nums[right] < pivot) {
                right--;
            }
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        if (left <= kth) {
            return quickSelect(nums, left, end, kth);
        } else if (kth <= right) {
            return quickSelect(nums, start, right, kth);
        }
        return nums[kth];
    }
}
