#include <iostream>

vector<string> generateParenthesis(int n) {
  vector<string> vec;
  helper(vec, "", n, 0);
  return vec;
}

void helper(vector<string>& vec, string str, int m, int n) {
// m表示要继续增加括号的对数，n表示所需右括号个数
//在增加括号的过程中保证右括号的个数始终不多于左括号的个数就能满足合法的条件
  if (m == 0 && n == 0) {
    vec.push_back(str);
    return;
  }
  if (m > 0) {
    helper(vec, str + "(", m - 1, n + 1);
  }
  if (n > 0) {
    helper(vec, str + ")", m, n - 1);
  }
}
