class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        char[] sc = s.toCharArray();
        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                dp[j][i] = (sc[i] == sc[j]) && (i - j < 2 || dp[j + 1][i - 1]);
                if (dp[j][i]) {
                    if (max < i - j + 1) {
                        start = j;
                        end = i;
                        max = i - j + 1;
                    }
                }   
            }    
        }
        return s.substring(start, end + 1);   
    }
}
