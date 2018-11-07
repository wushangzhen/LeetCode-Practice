class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        boolean[][] pattern = getPalin(s);
        int dp[] = new int[n + 1];
        dp[0] = 0;
        for (int j = 1; j <= n; j++) {
             dp[j] = Integer.MAX_VALUE;
            for (int i = 0; i < j; i++) {
                if (pattern[i][j - 1] && dp[i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[i] + 1, dp[j]);
                }
            }
        }
        return dp[n] - 1;
    }
    boolean[][] getPalin(String s) {
        int n = s.length();
        boolean[][] res = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res[left][right] = true;
                left--;
                right++;
            }
            left = i - 1;
            right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                res[left][right] = true;
                left--;
                right++;
            }
        }
        return res;
    }
}
