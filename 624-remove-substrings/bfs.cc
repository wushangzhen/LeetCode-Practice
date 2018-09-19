class Solution {
public:
    /*
     * @param s: a string
     * @param dict: a set of n substrings
     * @return: the minimum length
     */
    int minLength(string &s, unordered_set<string> &dict) {
        // write your code here
        if (s.size() == 0) {
            return 0;
        }
        queue<string> que;
        unordered_set<string> hashSet;
        que.push(s);
        hashSet.insert(s);
        int min = INT_MAX;
        while (!que.empty()) {
            string strTemp = que.front();
            que.pop();
            for (auto elemDict : dict) {
                int index = strTemp.find(elemDict);
                while (index != -1) {
                    string newStr = strTemp.substr(0, index) + 
                        strTemp.substr(index + elemDict.size()); 
                    if (hashSet.find(newStr) == hashSet.end()) {
                        if (newStr.size() < min) {
                            min = newStr.size();
                        }
                        que.push(newStr);
                        hashSet.insert(newStr);
                    }
                    index = strTemp.find(elemDict, index + 1);
                }
            }
        }
        return min;
    }
};
