class Solution {
public:
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    bool wordPatternMatch(string &pattern, string &str) {
        // write your code here
        unordered_map<char, string> hashMap;
        unordered_set<string> hashSet; 
        return match(pattern, str, hashMap, hashSet);
    }
    bool match(string pattern, 
               string str, 
               unordered_map<char, string>& hashMap,
               unordered_set<string>& hashSet) {
                   
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        char c = pattern[0];
        if (hashMap.find(c) != hashMap.end()) {
            if (str.substr(0, hashMap[c].size()) != hashMap[c]) {
                return false;
            }
            return match(pattern.substr(1),
                         str.substr(hashMap[c].size()),
                         hashMap, hashSet);
        }
        for (int i = 0; i < str.length(); i++) {
            string word = str.substr(0, i + 1);
            if (hashSet.find(word) != hashSet.end()) {
                continue;
            }
            hashMap[c] = word;
            hashSet.insert(word);
            if (match(pattern.substr(1), 
                str.substr(i + 1),
                hashMap, 
                hashSet)) {
                return true;    
            }
            hashSet.erase(word);
            hashMap.erase(c);
        }
        return false;
    }
};
