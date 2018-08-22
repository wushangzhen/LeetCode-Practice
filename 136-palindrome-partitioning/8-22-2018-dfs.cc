class Solution {
public:
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    vector<vector<string>> partition(string &s) {
        // write your code here
        vector<vector<string>> results;
        vector<string> vec;
        dfs(results, vec, s, 0);
        return results;
    }
    void dfs(vector<vector<string>>& results, vector<string>& vec, string &s, int startIndex) {
        if (startIndex == s.size()) {
            results.push_back(vec);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            string str = s.substr(startIndex, i + 1 - startIndex);
            if (!isPalidrome(str)) {
                continue;
            }
            vec.push_back(str);
            dfs(results, vec, s, i + 1);
            vec.pop_back();
        }
    }
    bool isPalidrome(string s) {
        for (int i = 0, j = s.size() - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }
};
