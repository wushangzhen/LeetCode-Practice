class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        if (n + m != k) {
            return false;
        }
        Boolean[][][] memo = new Boolean[n][m][k];
        return helper(0, 0, 0, s1, s2, s3, memo);
    }
    boolean helper(int p1, int p2, int p3, String s1, String s2, String s3, Boolean[][][] memo) {
        if (p1 == s1.length() && p2 == s2.length() && p3 == s3.length()) {
            return true;
        }
        if (p1 == s1.length()) {
            return s2.substring(p2).equals(s3.substring(p3));
        }
        if (p2 == s2.length()) {
            return s1.substring(p1).equals(s3.substring(p3));
        }
        if (memo[p1][p2][p3] != null) {
            return memo[p1][p2][p3];
        }
        boolean res = false;
        int a = s1.charAt(p1);
        int b = s2.charAt(p2);
        int c = s3.charAt(p3);
        if (a == c) {
            res = res || helper(p1 + 1, p2, p3 + 1, s1, s2, s3, memo);
            if (res) {
                memo[p1][p2][p3] = res;
                return res;
            }
        }
        if (b == c) {
            res = helper(p1, p2 + 1, p3 + 1, s1, s2, s3, memo);
        }
        memo[p1][p2][p3] = res;
        return res;
    }
}
