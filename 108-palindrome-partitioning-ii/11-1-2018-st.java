public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    boolean[][] getPalindrome(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int p = 0; p < n; p++) {
            int i = p;
            int j = p;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                res[i][j] = true;
                i--;
                j++;
            }
        }
        for (int p = 0; p < n; p++) {
            int i = p - 1;
            int j = p;
            while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
                res[i][j] = true;
                i--;
                j++;
            }
        }
        return res;
    }
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPalin = getPalindrome(s);
        int[] f = new int[n + 1];
        f[0] = 0;
        for (int i = 1; i <= n; i++) {
            f[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1] && f[j] != Integer.MAX_VALUE && f[j] + 1 < f[i]) {
                    f[i] = f[j] + 1;
                }
            }
        }
        return f[n] - 1;
        
    }
}
