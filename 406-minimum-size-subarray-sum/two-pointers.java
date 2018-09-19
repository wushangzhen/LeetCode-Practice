public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int minimumSize = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i < nums.length) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
                if (sum >= s) {
                    int size = j - i;
                    minimumSize = Math.min(minimumSize, size);
                    break;
                }
            }
            sum -= nums[i];
            i++;
            if (sum >= s && i < nums.length) {
                    int size = j - i;
                    minimumSize = Math.min(minimumSize, size);
            }
        }
        if (minimumSize == Integer.MAX_VALUE) {
            return -1;
        }
        return minimumSize;
    }
}
