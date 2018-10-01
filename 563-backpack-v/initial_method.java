public class Solution {
    /**
     * @param nums: an integer array and all positive numbers
     * @param target: An integer
     * @return: An integer
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        // initialize
        for (int i = 0; i <= target; i++) {
            f[0][i] = 0;
        } 
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] <= target) {
                f[i][nums[i - 1]] = 1;
            }
        }
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                f[i][j] = f[i - 1][j]; 
                if (j >= nums[i - 1]) {
                    f[i][j] += f[i - 1][j - nums[i - 1]];
                }
            }
        }
        return f[n][target];
    }
}
