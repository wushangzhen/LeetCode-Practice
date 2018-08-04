#include <unordered_map>
#include <string>
using namespace std;
class Solution {
public:
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    int longestPalindrome(string &s) {
        // write your code here
        unordered_map<char, int> un_map;
        if (s.empty()) {
            return 0;
        }
        int len = s.length();
        int zero = 0;
        int res = 0;
        bool flag = false;
        for (int i = 0; i < len; i++) {
            if (un_map.find(s[i]) == un_map.end()) {
                un_map[s[i]] = 1;
            } else {
                un_map[s[i]]++;
            }
        }
        unordered_map<char, int>::iterator iter = un_map.begin();
        for (; iter != un_map.end(); iter++) {
            if (iter->second % 2 == 0) {
                res += iter->second;
            } else {
                if (iter->second > 2) {
                    res += ((iter->second / 2) * 2);
                }
               flag = true; 
            }
        }
        if (flag == true) {
            res++;
        }
        return res;
    }
};
