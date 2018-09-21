public class Solution {
    /**
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        boolean[] f = new boolean[A.length];
        if (A == null && A.length == 0) {
            return false;
        }
        f[0] = true;
        for (int i = 1; i < A.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (f[j] && A[j] + j >= i) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[A.length - 1];
    }
}
