class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] visited = new boolean[n][m];
        boolean[][] memo = new boolean[n][m];
        return helper(0, s, 0, p, visited, memo);
    }
    boolean helper(int sIndex, String s, int pIndex, String p, boolean[][] visited, boolean[][] memo) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }
        if (sIndex == s.length()) {
            return isAllStar(pIndex, p);
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        boolean match;
        if (p.charAt(pIndex) == '*') {
            match = helper(sIndex + 1, s, pIndex, p, visited, memo) || helper(sIndex, s, pIndex + 1, p, visited, memo);
        } else {
            match = matchOne(sIndex, s, pIndex, p) && helper(sIndex + 1, s, pIndex + 1, p, visited, memo);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    boolean isAllStar(int index, String p) {
        for (int i = index; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    boolean matchOne(int sIndex, String s, int pIndex, String p) {
        return p.charAt(pIndex) == '?' || s.charAt(sIndex) == p.charAt(pIndex);
    }
}
