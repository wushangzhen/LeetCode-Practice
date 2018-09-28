public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return true;
        }
        int n = A.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (i == 0) {
                    f[i] = true;
                    continue;
                    
                }
                if (i != n - 1 && A[i] == 0) {
                    f[i] = false;
                    continue;
                }
                if (f[j] && j + A[j] >= i) {
                    f[i] = true;
                }
            }
        }
        return f[n - 1];
    }
}
