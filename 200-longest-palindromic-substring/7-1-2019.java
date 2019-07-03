class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return "";
        }
        boolean[][] dp = new boolean[n][n];
        int max = 1;
        int start = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && ((j + 1 > i - 1) || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (max < i - j + 1) {
                        start = j;
                        max = i - j + 1;
                    }
                }
            }
        }
        return s.substring(start, start + max);
    }
}
