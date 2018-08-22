class Solution {
public:
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    vector<string> wordBreak(string &s, unordered_set<string> &wordDict) {
        // write your code here
        map<string, vector<string>> memo;
        return wordBreakHelper(s, wordDict, memo);
    }
    vector<string> wordBreakHelper(string s, 
                                   unordered_set<string>& dict,
                                   map<string, vector<string>>& memo) {
        if (memo.find(s) != memo.end()) {
            return memo[s];
        }                                    
        vector<string> result;
        if (s.length() == 0) {
            return result;
        }
        if (dict.find(s) != dict.end()) {
            result.push_back(s);
        }
        for (int len = 1; len < s.length(); ++len) {
            string word = s.substr(0, len);
            if (dict.find(word) == dict.end()) {
                continue;
            }
            string suffix = s.substr(len);
            vector<string> segmentations= wordBreakHelper(suffix, dict, memo);
            for (auto segmentation : segmentations) {
                result.push_back(word + " " + segmentation);
            }
        }
        memo[s] = result; // remeber the result for next search
        return result;
    }
};
