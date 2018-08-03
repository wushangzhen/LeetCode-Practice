#include <string>
using namespace std;
class Solution {
public:
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    bool isPalindrome(string &s) {
        // write your code here
        int len = s.length();
        if (len == 0) {
            return true;
        }
        int left = 0, right = len - 1;
        while (left < right) {
            if (!isAlpha(s[left])) {
                left++;
            } 
            if (!isAlpha(s[right])) {
                right--;
            }
            if (isAlpha(s[left]) && isAlpha(s[right])) {
                if (((s[left] + 32 - 'a') % 32) != ((s[right] + 32 - 'a') % 32)) {
                    return false;
                } else {
                    left++;
                    right--;
                }
            } 
        }
        return true;
    }
private: 
    bool isAlpha(char &c) {
        if ('A' <= c && c <= 'Z') {
            return true;
        }
        if ('a' <= c && c <= 'z') {
            return true;
        }
        if ('0' <= c && c <= '9') {
            return true;
        }
        return false;
    }
};



