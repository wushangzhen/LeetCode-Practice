public class Solution {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums.length == 0 || k < 1 || k > nums.length) {
            return -1;
        }
        int n = nums.length;
        return quickSelect(0, n - 1, nums, k - 1); // k - 1 is necessary because 
        // in the quick select method we have to deal with index;
    }
    public int quickSelect(int start, int end, int[] nums, int k) {
        if (start >= end) {
           return nums[start];
        }
        int left = start;
        int right = end;
        int pivot = nums[(start + end) / 2];
        while (start <= end) {
            while (start <= end && nums[start] > pivot) {
                start++;
            }
            while (start <= end && nums[end] < pivot) {
                end--;
            }
            if (start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
        if (end >= k) {
            return quickSelect(left, end, nums, k);
        } 
        if (start <= k) {
            return quickSelect(start, right, nums, k);
        }
        return nums[end + 1];
            
    }
}
