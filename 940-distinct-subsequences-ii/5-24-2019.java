class Solution {
    public int distinctSubseqII(String S) {
        int n = S.length();
        int[] dp = new int[n]; // count of unique subseq ends with Character S[i]
        int MOD = 1_000_000_007;
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (S.charAt(i) != S.charAt(j)) {
                    dp[i] = (dp[i] + dp[j]) % MOD;
                }
            }
            res += dp[i];
            res %= MOD;
        }
        return res;
    }
}
