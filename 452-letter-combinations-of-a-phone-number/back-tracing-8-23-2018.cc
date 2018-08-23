class Solution {
public:
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    unordered_map<char, string> hashMap;
    vector<string> letterCombinations(string &digits) {
        // write your code here
        hashMap['0'] = "";
        hashMap['1'] = "";
        hashMap['2'] = "abc";
        hashMap['3'] = "def";
        hashMap['4'] = "ghi";
        hashMap['5'] = "jkl";
        hashMap['6'] = "mno";
        hashMap['7'] = "pqrs";
        hashMap['8'] = "tuv";
        hashMap['9'] = "wxyz";
        vector<string> results;
        if (digits == "") {
            return results;
        }
        string str = "";
        dfs(results, str, 0, digits);
        return results;
    }
    void dfs(vector<string>& results, string& str, int startIndex, string& digits) {
        if (str.size() == digits.size()) {
            results.push_back(str);
            return;
        }
        for (int j = 0; j < hashMap[digits[startIndex]].size(); j++) {
            stringstream ss;
            ss << hashMap[digits[startIndex]][j];
            string temp = "";
            ss >> temp;
            str += temp;
            dfs(results, str, startIndex + 1, digits);
            str = str.substr(0, str.length() - 1);
        }
    }
};
