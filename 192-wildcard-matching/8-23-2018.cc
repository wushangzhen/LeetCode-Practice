class Solution {
public:
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    bool isMatch(string &s, string &p) {
            // write your code here
        if (p == "") {
            return false;
        }
        vector<vector<bool>> memo(s.length(), vector<bool>(p.length(), false));
        vector<vector<bool>> visited(s.length(), vector<bool>(p.length(), false));
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }
    bool isMatchHelper(string s, int sIndex,
                       string p, int pIndex,
                       vector<vector<bool>>& memo, 
                       vector<vector<bool>>& visited) {
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }                    
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        char sChar = s[sIndex];
        char pChar = p[pIndex];
        bool match;
        if (pChar == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited) || 
                isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited) && charMatch(sChar, pChar);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    bool charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }
    bool allStar(string p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p[i] != '*') {
                return false;
            }
        }
        return true;
    }
};
// remember search and dfs
