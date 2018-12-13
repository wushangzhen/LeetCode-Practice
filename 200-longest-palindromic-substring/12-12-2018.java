class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if ((i - j < 2 || dp[j + 1][i - 1]) && s.charAt(i) == s.charAt(j)) {
                    if (max < i - j + 1) {
                        start = j;
                        max = i - j + 1;
                    }
                    dp[j][i] = true;
                } 
            }
        }
        return s.substring(start, start + max);
    }
}
