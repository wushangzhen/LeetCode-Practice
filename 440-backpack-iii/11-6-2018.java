public class Solution {
    /**
     * @param A: an integer array
     * @param V: an integer array
     * @param m: An integer
     * @return: an array
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int n = A.length;
        int[] dp = new int[m + 1];
        dp[0] = 0; 
        for (int i = 0; i < n; i++) {
            int size = A[i];
            int value = V[i];
            for (int j = size; j <= m; j++) {
                dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
        return dp[m];
    }
}
