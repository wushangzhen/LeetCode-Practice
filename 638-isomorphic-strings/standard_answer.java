public class Solution {
    /**
     * @param s: a string
     * @param t: a string
     * @return: true if the characters in s can be replaced to get t or false
     */
    public boolean isIsomorphic(String s, String t) {
        // write your code here
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        int[] A = new int[256];
        int i = 0;
        int j = 0;
        while (i < s.length()) {
            if (A[sc[i]] != 0 && A[sc[i]] != tc[i]) {
                return false;
            }
            if (A[sc[i]] == 0) {
                A[sc[i]] = tc[i];
            }
            i++;
        }
        int[] B = new int[256];
        while (j < t.length()) {
            if (B[tc[j]] != 0 && B[tc[j]] != sc[j]) {
                return false;
            }
            if (B[tc[j]] == 0) {
                B[tc[j]] = sc[j];
            }
            j++;
        }
        return true;
    }
}
