#include <iostream>
#include <string>
using namespace std;

string longestPalindrome(string s) {
  if (s.length() == 0) {
    return "";
  }
  //int **dp = new int[s.length()][s.length()];
  int dp[s.size()][s.size()] = {0}; // cannot pass
  int left = 0, right = 0, len = 0;
  for (int j = 0; j < s.length(); ++j) {
    for (int i = 0; i < j; ++i) {
      dp[i][j] = (s[i] == s[j] && (j - i < 2 || dp[i + 1][j - 1]));
      if (dp[i][j] && len < j - i + 1) {
        len = j - i + 1;
        left = i;
        right = j;
      } 
    }
    dp[j][j] = 1;
  }
  return s.substr(left, right - left + 1);
  //delete []dp;
  //dp = NULL;
}

int main() {
  string str = "aabba";
  cout << longestPalindrome(str) << endl;
}
