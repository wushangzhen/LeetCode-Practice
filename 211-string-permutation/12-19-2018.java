public class Solution {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A == null && B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (B == null) {
            return false;
        }
        if (A.length() != B.length()) {
            return false;
        }
        int[] memo = new int[256];
        for (int i = 0; i < A.length(); i++) {
            memo[A.charAt(i)]++;
        }
        for (int i = 0; i < B.length(); i++) {
            memo[B.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (memo[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
