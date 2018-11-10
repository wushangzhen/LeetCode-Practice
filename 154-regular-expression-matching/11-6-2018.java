public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        int n = s.length();
        int m = p.length();
        boolean[][] memo = new boolean[n][m]; 
        boolean[][] visited = new boolean[n][m];
        return helper(0, s, 0, p, memo, visited);
    }
    boolean helper(int indexS, String s, int indexP, String p, 
        boolean[][] memo, boolean[][] visited) {
            if (indexP == p.length()) {
                return indexS == s.length();
            }
            if (indexS == s.length()) {
                return isAllStar(indexP, p);
            }
            if (visited[indexS][indexP]) {
                return memo[indexS][indexP];
            }
            boolean match = false;
            if (indexP + 1 < p.length() && p.charAt(indexP + 1) == '*') {
                match = helper(indexS, s, indexP + 2, p, memo, visited) 
                    || (oneMatch(indexS, s, indexP, p) && helper(indexS + 1, s, indexP, p, memo, visited));
            } else {
                match = oneMatch(indexS, s, indexP, p) && 
                    helper(indexS + 1, s, indexP + 1, p, memo, visited);
            }
            visited[indexS][indexP] = true;
            memo[indexS][indexP] = match;
            return match;
        } 
    boolean isAllStar(int index, String p) {
        for (int i = index + 1; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
    boolean oneMatch(int sIndex, String s, int pIndex, String p) {
        return s.charAt(sIndex) == p.charAt(pIndex) || p.charAt(pIndex) == '.';
    }
}
