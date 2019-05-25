class Solution {
    private int MOD = 1000000007;
    public int countPalindromicSubsequences(String S) {
        TreeSet<Integer>[] count = new TreeSet[26];
        for (int i = 0; i < 26; i++) {
            count[i] = new TreeSet<>();
        }
        int n = S.length();
        for (int i = 0; i < n; i++) {
            count[S.charAt(i) - 'a'].add(i);
        }
        Integer[][] dp = new Integer[n + 1][n + 1];
        return helper(S, dp, count, 0, n);
    }
    int helper(String S, Integer[][] dp, TreeSet<Integer>[] count, int start, int end) {
        if (start >= end) {
            return 0;
        } 
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            Integer new_start = count[i].ceiling(start);
            Integer newStart = count[i].ceiling(start);
            Integer newEnd = count[i].lower(end);
            if (newStart == null || newStart >= end) {
                continue;
            }
            ans++;
            if (newStart != newEnd) {
                ans++;
            }
            ans = (ans + helper(S, dp, count, newStart + 1, newEnd)) % MOD;
        }
        dp[start][end] = ans;
        return ans;
    }
}
