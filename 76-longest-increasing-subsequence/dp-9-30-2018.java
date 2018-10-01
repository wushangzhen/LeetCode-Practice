public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] f = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (nums[i] > nums[i - j]) {
                    f[i] = Math.max(f[i - j] + 1, f[i]);
                }
                max = Math.max(max, f[i]);
            }
        }
        return max;
    }
}
