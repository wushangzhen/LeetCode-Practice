#include <iostream>
#include <string>
using namespace std;
bool isPalindrome(int i, int j, string s) {
  while (i <= j) {
    if (s[i] != s[j]) {
      return false;
    } 
    i++;
    j--;
  }
  return true;
}

string longestPalindromeSubstring(string s) {
  int len = s.length();
  if (!len) {
    return "";
  }
  int result = 0;
  string res_str = "";
  for (int i = 0; i < len; i++) {
    int left = i;
    for (int j = i; j < len; j++) {
      int right = j; 
      if (isPalindrome(left, right, s)) {
        int subLength = right - left + 1;
        if (subLength >= result) {
          res_str = s.substr(i, subLength);
          result = subLength;
        }
      }
    }
  }
  return res_str;
}


int main() {
  string s = "abbcb";
  cout << longestPalindromeSubstring(s) << endl;
}
