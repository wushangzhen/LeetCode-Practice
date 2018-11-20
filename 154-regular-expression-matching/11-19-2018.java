class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] visited = new boolean[n][m];
        boolean[][] memo = new boolean[n][m];
        return helper(0, 0, s, p, visited, memo);
    }
    boolean helper(int sStart, int pStart, String s, String p, boolean[][] visited, boolean[][] memo) {
        if (pStart == p.length()) {
            return sStart == s.length();
        } 
        if (sStart == s.length()) {
            return allStar(pStart, p);
        }
        if (visited[sStart][pStart]) {
            return memo[sStart][pStart];
        }
        boolean match = false;
        if (pStart + 1 < p.length() && p.charAt(pStart + 1) == '*') {
            match = helper(sStart, pStart + 2, s, p, visited, memo) 
                || (matchChar(sStart, pStart, s, p) && helper(sStart + 1, pStart, s, p, visited, memo));
        } else {
            match = matchChar(sStart, pStart, s, p) && helper(sStart + 1, pStart + 1, s, p, visited, memo);
        }
        visited[sStart][pStart] = true;
        memo[sStart][pStart] = match;
        return match;
    }
    boolean matchChar(int sStart, int pStart, String s, String p) {
        return s.charAt(sStart) == p.charAt(pStart) || p.charAt(pStart) == '.';
    }
    boolean allStar(int pStart, String p) {
        for (int i = pStart; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}
