#include <iostream>
#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

void helper(vector<string>& vec_res, string path, int ix, int j, string digits, 
    unordered_map<int, string>& un_map) {
  if (path.size() == digits.size()) {
    vec_res.push_back(path);
    return;
  }
  for (int i = ix, j = 0; i < digits.size(); i++) {
    for (;j < un_map[digits[i] - '0'].size(); j++) {
      path += (un_map[digits[i] - '0'])[j];
      helper(vec_res, path, i + 1, j, digits, un_map);
      path.erase(path.end() - 1);
    }
  }
}
vector<string> letterCombinations(string digits) {
  unordered_map<int, string> un_map = {{1, ""}, {2, "abc"}, {3, "def"}, 
      {4, "ghi"}, {5, "jkl"}, {6, "mno"}, {7, "pqrs"}, {8, "tuv"}, {9, "wxyz"}};
  vector<string> vec_res;
  string path("");
  helper(vec_res, path, 0, 0, digits, un_map);
  return vec_res;
}

int main() {
  string str("67");
  vector<string> vec = letterCombinations(str);
  for (auto s : vec) {
    cout << s << endl;
  }
}
