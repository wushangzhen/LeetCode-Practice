class Solution {
public:
    /*
     * @param : A string
     * @param : A set of word
     * @return: the number of possible sentences.
     */
    unordered_map<string, int> memo;
    int wordBreak3(string& s, unordered_set<string>& dict) {
        // Write your code here
        if (s.size() == 0 || dict.size() == 0) {
            return 0;
        }
        unordered_set<string> newDict;
        for (auto elem : dict) {
            transform(elem.begin(), elem.end(), elem.begin(), ::tolower);
            newDict.insert(elem);
        }
        transform(s.begin(), s.end(), s.begin(), ::tolower);
        return memoDfs(s, newDict);
    }
    int memoDfs(string s, unordered_set<string>& newDict) {
        if (s.size() == 0) {
            return 1;
        }
        if (memo.find(s) != memo.end()) {
            return memo[s];
        }
        int times = 0;
        for (int i = 0; i < s.size(); i++) {
            string str = s.substr(0, i + 1);
            if (newDict.find(str) == newDict.end()) {
                continue;
            } 
            times += memoDfs(s.substr(i + 1), newDict); 
        }
        memo[s] = times;
        return times;
    }
};
