class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int n = s.length();
        int m = p.length();
        boolean[][] visited = new boolean[n][m];
        boolean[][] memo = new boolean[n][m];
        return helper(s, 0, p, 0, memo, visited);
    }
    
    boolean helper(String s, int sIndex, String p, int pIndex, boolean[][] memo, boolean[][] visited) {
        if (sIndex == s.length()) {
            return empty(p, pIndex);
        }
        if (pIndex == p.length()) {
            return s.length() == sIndex;
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        boolean match;
        if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) == '*') {
             match = helper(s, sIndex, p, pIndex + 2, memo, visited) 
                || (matchChar(s, sIndex, p, pIndex) && helper(s, sIndex + 1, p, pIndex, memo, visited));
        } else {
            match = matchChar(s, sIndex, p, pIndex) && helper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }
        visited[sIndex][pIndex] = match;
        return match;
    }
    boolean matchChar(String s, int sIndex, String p, int pIndex) {
        return s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
    }
    boolean empty(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            if (i + 1 >= p.length() || p.charAt(i + 1) != '*') {
                return false;
            }
        }
        return true;
    }
}

