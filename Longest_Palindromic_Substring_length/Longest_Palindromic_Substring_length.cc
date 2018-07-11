#include <iostream>
#include <string>
using namespace std;
bool isPalindrome(int i, int j, string s) {
//  while (i < j && s[i] == s[j]) {
//    i++;
//    j--;
//  }
//  if (i == j) {
//    return true;
//  } else {
//    return false;
//  }
  while (i <= j) {
    if (s[i] != s[j]) {
      return false;
    } 
    i++;
    j--;
  }
  return true;
}

int longestPalindrome(string s) {
  int len = s.length();
  int result = 0;
  for (int i = 0; i < len; i++) {
    int left = i;
    for (int j = i; j < len; j++) {
      int right = j; 
      if (isPalindrome(left, right, s)) {
        result = max(right - left + 1, result);
      }
    }
  }
  return result;
}


int main() {
  string s = "abbcb";
  cout << longestPalindrome(s) << endl;
}
