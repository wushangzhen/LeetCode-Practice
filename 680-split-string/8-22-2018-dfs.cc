class Solution {
public:
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    vector<vector<string>> splitString(string& s) {
        // write your code here
        vector<vector<string>> results;    
        vector<string> vec;
        dfs(0, s, vec, results);
        return results;
    }
    void dfs(int index, string& s, vector<string> &vec, vector<vector<string>>& results) {
        if (index >= s.length()) {
            results.push_back(vec);    
            return;
        }
        if (index + 1 <= s.length()) {
            string str = s.substr(index, 1);
            vec.push_back(str);
            dfs(index + 1, s, vec, results);
            vec.pop_back();
        }
        if (index + 2 <= s.length()) {
            string str = s.substr(index, 2);
            vec.push_back(str);
            dfs(index + 2, s, vec, results);
            vec.pop_back();
        }
        return;
    }
    void dfs(string s, vector<string>& vec, vector<vector<string>>& results) {
        if (s == "") {
            result.push_back(vec);
            return;
        }
        for (int i = 1; i <= 2; i++) {
            if (i <= s.length) {
                vec.push_back(s.substr(0, i));
                dfs(s.substr(i, s.length()), vec, result);
                vec.pop_back();
            }
        }
    }
};
