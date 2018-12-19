public class Solution {
    /**
     * @param nums: an integer array
     * @param low: An integer
     * @param high: An integer
     * @return: nothing
     */
    public void partition2(int[] nums, int low, int high) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        for (int i = left; i <= right; i++) {
            if (nums[i] < low) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            } else if (nums[i] > high) {
                int temp = nums[i];
                nums[i] = nums[right];
                nums[right] = temp;
                right--;
                i--;
            }
        }
    }
}
