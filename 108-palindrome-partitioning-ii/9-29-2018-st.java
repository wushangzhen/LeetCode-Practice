public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int minCut(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] isPalin = calPalin(s);
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
    boolean[][] calPalin(String s) {
        int left, right;
        int n = s.length();
        boolean[][] result = new boolean[n][n];
        result[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            left = right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result[left][right] = true; 
                left--;
                right++;
            }
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                result[left][right] = true;
                left--;
                right++;
            }
        }
        return result;
    }
}
