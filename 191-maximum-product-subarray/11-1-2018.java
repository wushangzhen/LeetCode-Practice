public class Solution {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int result = nums[0];
        int[] max = new int[n];
        int[] min = new int[n];
        min[0] = nums[0];
        max[0] = nums[0];
        for (int i = 1; i < n; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i - 1] * nums[i], max[i]);
                min[i] = Math.min(min[i - 1] * nums[i], min[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(min[i - 1] * nums[i], max[i]);
                min[i] = Math.min(max[i - 1] * nums[i], min[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
}
