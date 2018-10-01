public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        int[] f = new int[target + 1];
        f[0] = 1; 
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    f[i] += f[i - nums[j]];
                }
            }
        }
        return f[target];
    }
}
