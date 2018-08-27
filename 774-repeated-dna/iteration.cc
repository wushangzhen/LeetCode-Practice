class Solution {
public:
    /**
     * @param s: a string represent DNA sequences
     * @return: all the 10-letter-long sequences 
     */
    vector<string> findRepeatedDna(string &s) {
        // write your code here
        int len = s.length();
        vector<string> result;
        unordered_set<string> hashSet1; 
        unordered_set<string> hashSet2; 
        for (int i = 0; i <= len - 10; i++) {
            if (hashSet1.find(s.substr(i, 10)) != hashSet1.end() &&
                hashSet2.find(s.substr(i, 10)) == hashSet2.end()) {
                result.push_back(s.substr(i, 10));
                hashSet2.insert(s.substr(i, 10));
                continue;
            }
            hashSet1.insert(s.substr(i, 10));
        }
        return result;
    }
};
