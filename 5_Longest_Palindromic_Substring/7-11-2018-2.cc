// This is a O(n^2) problem
// we can use central point enumeration method 
#include <iostream>
#include <string>
using namespace std;
class Solution {
public:
    string longestPalindrome(string s) {
        if (s.empty() || !s.length()) {
            return "";
        }
        int len = 0, start = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = findPalindromeForm(s, i, i);
            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
            len = findPalindromeForm(s, i, i + 1);
            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }
        }
        return s.substr(start, longest);
    }

private:
    int findPalindromeForm(string s, int left, int right) {
        int len = 0;
        while (left >= 0 && right < s.length()) {
            if (s[left] != s[right]) {
              break;
            }
            len += left == right ? 1 : 2;
            left--;
            right++;
        } 
        return len;
    }
};

int main() {
    Solution s;
    cout << s.longestPalindrome("abccb") << endl;
}
