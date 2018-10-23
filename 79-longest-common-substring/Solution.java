public class Solution {
    /**
     * @param A: A string
     * @param B: A string
     * @return: the length of the longest common substring.
     */
    public static int longestCommonSubstring(String A, String B) {
        // write your code here
        int res = Integer.MIN_VALUE;
        if (A == null || B == null || A.length() == 0 || B.length() == 0) {
            return 0;
        }
        char[] ac = A.toCharArray();
        char[] bc = B.toCharArray();
        for (int i = 0; i < ac.length; i++) {
            for (int j = 0; j < bc.length; j++) {
                int cur = 1;
                while (i + cur <= ac.length && j + cur <= bc.length) {
                    if (A.substring(i, i + cur).equals(B.substring(j, j + cur))) {
                        if (cur > res) {
                            res = cur;
                        }
                    }
                    cur++;
                }
            }
        }
        return res == Integer.MIN_VALUE ? 0 : res;
    }
    public static void main(String[] args) {
        System.out.println(Solution.longestCommonSubstring("abc", "a"));
    }
}
