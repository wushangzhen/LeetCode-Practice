class Solution {
public:
    /**
     * @param s: A string 
     * @param p: A string includes "." and "*"
     * @return: A boolean
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
            return isEmpty(p, pIndex);
        }
        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }
        char sChar = s[sIndex];
        char pChar = p[pIndex];
        bool match;
        if (pIndex + 1 < p.length() && p[pIndex + 1] == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 2, memo, visited) || 
                charMatch(sChar, pChar) && isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited) && charMatch(sChar, pChar);
        }
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    bool charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '.');
    }
    bool isEmpty(string p, int pIndex) {
        for (int i = pIndex; i < p.length(); i += 2) {
            if (i + 1 <= pIndex || p[i+1] != '*') {
                return false;
            }
        }
        return true;
    }
};
