class Solution {
    public int distinctSubseqII(String S) {
        int[] count = new int[26];
        int res = 0;
        int add = 0;
        int MOD = 1_000_000_007;
        for (int i = 0; i < S.length(); i++) {
            add = (res - count[S.charAt(i) - 'a'] % MOD + 1) % MOD;
            res = (res + add) % MOD;
            count[S.charAt(i) - 'a'] = (count[S.charAt(i) - 'a'] + add) % MOD;
        }
        return (res + MOD) % MOD;
    }
}
