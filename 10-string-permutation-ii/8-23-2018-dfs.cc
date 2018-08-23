class Solution {
public:
    /**
     * @param str: A string
     * @return: all permutations
     */
    vector<string> stringPermutation2(string &str) {
        // write your code here
        vector<string> results;
        if (str == "") {
            results.push_back(str);
            return results;
        }
        string cur = "";
        //unordered_map<char, bool> hashMap;
        vector<bool> vecIndex = {false};
        dfs(results, cur, str, vecIndex);
        return results;
    }
    void dfs(vector<string>& results, string& cur, string& str, vector<bool>& vecIndex) {
        if (cur.size() == str.size()) {
            results.push_back(cur);
            return;
        }
        unordered_map<char, bool> hashMap;
        for (int i = 0; i < str.size(); i++) {
            if (vecIndex[i] == false && hashMap.find(str[i]) == hashMap.end()) {
                stringstream ss;
                ss << str[i];
                string temp = "";
                ss >> temp;
                cur += temp;
                vecIndex[i] = true;
                dfs(results, cur, str, vecIndex);
                vecIndex[i] = false;
                cur.erase(cur.length() - 1, 1);
                hashMap[str[i]] == true;
            }
        }
    }
};
