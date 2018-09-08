class Solution {
public:
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    unordered_map<string, bool> memo;
    int longest = 0;
    bool wordBreak(string &s, unordered_set<string> &dict) {
        // write your code here
        if (s.size() == 0 && dict.size() == 0) {
            return true;
        }
        if (s.size() != 0 && dict.size() == 0) {
            return false;
        }
        if (s.size() == 0 && dict.size() != 0) {
            return false;
        }
        for (auto word : dict) {
            if (word.size() > longest) {
                longest = word.size();
            }
        }
        return memoDfs(s, dict);
    }
    bool memoDfs(string s, unordered_set<string>& dict) {
        if (s.empty()) {
            return true;
        }
        if (memo.find(s) != memo.end()) {
            return memo[s];
        }
        for (int i = 0; i < longest; i++) {
            string str = s.substr(0, i + 1);
            if (dict.find(str) == dict.end()) {
                continue;
            }
            memo[s] = memoDfs(s.substr(i + 1), dict);
            if (memo[s]) {
                break;
            }
        }
        return memo[s];
    }
};
