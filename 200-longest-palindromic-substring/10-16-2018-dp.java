class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s.length() == 0) {
            return result;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] sc = s.toCharArray();
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                dp[j][i] = (sc[i] == sc[j]) && (i - j < 2 || dp[j + 1][i - 1]);
                if (dp[j][i]) {
                    if (len < i - j + 1) {
                        start = j;
                        end = i;
                        len = i - j + 1;
                    }
                }
                dp[i][i] = true;
            }
        }
        return s.substring(start, end + 1);
    }
}
