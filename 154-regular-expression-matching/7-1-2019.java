class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (n == 0 && m == 0) {
            return true;
        }
        Boolean[][] memo = new Boolean[n][m];
        return helper(0, 0, s, p, memo);
    }
    boolean helper(int ss, int pp, String s, String p, Boolean[][] memo) {
        if (pp == p.length()) {
            return ss == s.length();
        }
        if (ss == s.length()) {
            return check(p, pp);
        }
        if (memo[ss][pp] != null) {
            return memo[ss][pp];
        }
        boolean res = false;
        if (pp + 1 < p.length() && p.charAt(pp + 1) == '*') {
            if (s.charAt(ss) != p.charAt(pp) && p.charAt(pp) != '.') {
                res = helper(ss, pp + 2, s, p, memo);
            } else {
                res = helper(ss + 1, pp, s, p, memo) || helper(ss, pp + 2, s, p, memo);
            }
        } else if (s.charAt(ss) == p.charAt(pp) || p.charAt(pp) = '.') {
            res = helper(ss + 1, pp + 1, s, p, memo);
        }
        memo[ss][pp] = res;
        return res;
    }
    boolean check(String p, int pp) {
        for (int i = pp; i < p.length(); i += 2) {
            if (i + 1 < p.length() && p.charAt(i + 1) == '*') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
