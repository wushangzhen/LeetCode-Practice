public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;
        int[][] localMax = new int[len + 1][k + 1];
        int[][] globalMax = new int[len + 1][k + 1];
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= i && j <= k; j++) {
                localMax[j - 1][j] = Integer.MIN_VALUE;
                globalMax[j - 1][j] = Integer.MIN_VALUE;
                localMax[i][j] = Math.max(globalMax[i - 1][j - 1], localMax[i - 1][j]) + nums[i - 1];
                globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
            }
        }
        return globalMax[len][k];
    }
}
