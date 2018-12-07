public class Solution {
    /**
     * @param A: An integer array
     * @param start: An integer
     * @param end: An integer
     * @return: the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] preSum = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += A[i - 1];
            preSum[i] = sum;
        }
        int l = 0;
        int r = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            while (l < i && preSum[i] - preSum[l] > end) {
                l++;
            }
            while (r < i && preSum[i] - preSum[r] >= start) {
                r++;
            }
            res += r - l;
        }
        return res;
    }
}
