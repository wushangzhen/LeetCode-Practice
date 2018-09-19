public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int median = 0;
        if (nums.length % 2 == 0) {
            median = nums.length / 2;
        } else {
            median = nums.length / 2 + 1;
        }
        return quickSelect(0, nums.length - 1, median - 1, nums);
    }
    public int quickSelect(int start, int end, int median, int[] nums) {
        if (start >= end) {
            return nums[start];
        }
        int left = start;
        int right = end;
        int mid = nums[(left + right) / 2];
        while (left <= right) {
            while (left <= right && nums[left] < mid) {
                left++;
            }
            while (left <= right && nums[right] > mid) {
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
        if (median <= right) {
            return quickSelect(start, right, median, nums);
        }
        if (median >= left) {
            return quickSelect(left, end, median, nums);
        }
        return nums[right + 1];
        
    }
}
