class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        if (s == null || s == "") {
            return result;
        }
        int n = s.length();
        char[] sc = s.toCharArray();
        boolean[][] dp = new boolean[n][n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int start = i;
            int end = i; 
            while (start == end || start >= 0 && end < n && (sc[start] == sc[end] && dp[start + 1][end - 1])) {
                dp[start][end] = true;
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                start--;
                end++;
            }
            start = i;
            end = i + 1;
            while ((start >= 0 && end < n && start == end - 1 && sc[start] == sc[end]) || (start >= 0 && end < n 
                && sc[start] == sc[end] && dp[start + 1][end - 1])) {
                dp[start][end] = true;
                if (end - start + 1 > max) {
                    max = end - start + 1;
                    result = s.substring(start, end + 1);
                }
                start--;
                end++;
            }
        }
        return result;
    }
}
