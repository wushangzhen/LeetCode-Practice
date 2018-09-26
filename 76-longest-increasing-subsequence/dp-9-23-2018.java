public class Solution {
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] A) {
        // write your code here
        int n = A.length;
        int[] f = new int[n];
        int max = 0;
        for (int j = 0; j < n; ++j) {
            f[j] = 1;
            for (int i = 0; i < j; ++i) {
                if (A[i] < A[j]) {
                    f[j] = Math.max(f[i] + 1, f[j]);
                }
                max = Math.max(max, f[j]);
            }
        }
        return max;
    }
}
