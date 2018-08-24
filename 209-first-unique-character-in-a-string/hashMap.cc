class Solution {
public:
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    char firstUniqChar(string &str) {
        // Write your code here
        unordered_map<char, int> hashMap;
        for (int i = 0; i < str.size(); i++) {
            hashMap[str[i]]++;
        }
        for (int i = 0; i < str.size(); i++) {
            if (hashMap[str[i]] == 1) {
                return str[i];
            }
        }
    }
};
