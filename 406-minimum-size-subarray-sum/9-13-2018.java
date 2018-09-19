public class Solution {
    /**
     * @param nums: an array of integers
     * @param s: An integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your cde here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int i = 0;
        int j = 0;
        int minNum = Integer.MAX_VALUE;
        int sum = 0;
        for (; i < nums.length; i++) {
            while (j < nums.length && sum < s) {
                sum += nums[j];
                j++;
            } 
            if (sum >= s && j - i < minNum) {
                minNum = j - i;
            }
            sum -= nums[i];
        }
        if (minNum == Integer.MAX_VALUE) {
            return -1;
        }
        return minNum;
    }
}
