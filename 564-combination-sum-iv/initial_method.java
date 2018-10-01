public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (target == 0) {
            return 1;
        }
        int n = nums.length;
        int[][] f = new int[n + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            f[i][0] = 1;
        }
        f[0][0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 1; i <= n; i++) {
                f[i][j] = f[i - 1][j];
                if (j >= nums[i - 1]) {
                    f[i][j] += f[n][j - nums[i - 1]];
                }
            }
        }
        return f[n][target];
    }
}
