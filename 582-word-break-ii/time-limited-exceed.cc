class Solution {
public:
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    vector<string> wordBreak(string &s, unordered_set<string> &wordDict) {
        // write your code here
        vector<string> results;
        string str = "";
        if (s.empty() || wordDict.empty()) {
            return results;
        }
        dfs(results, str, 0, wordDict, s);
        return results;
    }
    void dfs(vector<string>& results, string &str, int startIndex, unordered_set<string>wordDict, string s) {
        if (startIndex >= s.size()) {
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            string strTemp = s.substr(startIndex, i + 1 - startIndex);
            if (wordDict.find(strTemp) != wordDict.end()) {
                if (str == "") {
                    str += strTemp; 
                } else {
                    str += " ";
                    str += strTemp; 
                }
                if (i == s.length() - 1) {
                    results.push_back(str);
                }
                s = s.substr(strTemp.size(), s.length() - strTemp.size());
                dfs(results, str, 0, wordDict, s);
                //int last = str.size() - 1;
                //if (str[last] == ' ') {
                //    str.erase(str.length() - 1, 1);
                //}
                
                int j = str.length() - 1;
                while (str[j] != ' ' && j > 0) {
                    j--;
                }
                str = str.substr(0, j);
                //str.erase(j, str.length() - j - 1);
            }
            //dfs(results, str, i + 1, wordDict, s);
        }
    }
};
