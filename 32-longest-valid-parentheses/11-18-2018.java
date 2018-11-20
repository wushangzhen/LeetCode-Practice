class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } 
        int n = s.length();
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '(') {
                dp[i] = 0;
            } else {
                if (i != 1) {
                    if (s.charAt(i - 2) == '(') {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        if (i - dp[i - 1] - 2 >= 0) {
                            if (s.charAt(i - dp[i - 1] - 2) == '(') {
                                dp[i] = dp[i - dp[i - 1] - 2] + dp[i - 1] + 2;
                            }
                        }
                    }
                } 
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
