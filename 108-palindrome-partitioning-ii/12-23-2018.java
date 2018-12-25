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
        boolean[][] isPalin = getPalin(s);
        int n = s.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalin[j][i - 1] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[n] - 1;
    }
    boolean[][] getPalin(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < s.length(); i++) {
            p1 = i;
            p2 = i;
            while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)) {
                res[p1][p2] = true;
                p1--;
                p2++;
            }
            p1 = i - 1;
            p2 = i;
            while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)) {
                res[p1][p2] = true;
                p1--;
                p2++;
            }
        }
        return res;
    }
}
