class Solution {
public:
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    bool wordBreak(string &s, unordered_set<string> &dict) {
        int max_length = 0;
        for (auto iter = dict.begin(); iter != dict.end(); ++iter) {
            max_length = max(max_length, static_cast<int>((*iter).length()));
        }
        vector<vector<string>> result;
        vector<string> path;
        dfs(result, path, 0, s, dict, max_length);
        return result.size() > 0;
    }
    void dfs(   vector<vector<string>>& result, 
                vector<string>& path, 
                int index, 
                string& s, 
                unordered_set<string>& dict,
                int max_length) {
        if (index == s.length()) {
            result.push_back(path);
            return;
        }
        for (int i = 1; i <= max_length; ++i) {
            if (index + i > s.length()) break;
            string word = s.substr(index, i);
            if (dict.find(word) == dict.end()) continue;
            path.push_back(word);
            dfs(result, path, index + i, s, dict, max_length);
            path.pop_back();
        }
    }
};
