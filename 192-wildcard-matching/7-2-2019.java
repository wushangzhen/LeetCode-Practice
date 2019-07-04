class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        Boolean[][] memo = new Boolean[n][m];
        return helper(0, 0, s, p, memo);
    }
    boolean helper(int ss, int pp, String s, String p, Boolean[][] memo) {
        if (pp == p.length()) {
            return ss == s.length();
        }
        if (ss == s.length()) {
            return check(pp, p);
        }
        if (memo[ss][pp] != null) {
            return memo[ss][pp];
        }
        boolean res = false;
        if (p.charAt(pp) == '*') {
            res = helper(ss + 1, pp, s, p, memo) || helper(ss, pp + 1, s, p, memo);
        } else if (p.charAt(pp) == s.charAt(ss) || p.charAt(pp) == '?') {
            res = helper(ss + 1, pp + 1, s, p, memo);
        }
        return memo[ss][pp] = res;
    }
    boolean check(int pp, String p) {
        for (int i = pp; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
