class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            int j = i - dp[i - 1] - 2;
            if (s.charAt(i - 1) == '(' || j < 0 || s.charAt(j) == ')') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + dp[j] + 2;
                res = Math.max(dp[i], res);
            }
        }
        return res;
    }
}
