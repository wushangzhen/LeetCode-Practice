#include <iostream>
#include <string>
using namespace std;
string reverseWords(string S) {
  string s = S;
  int index = s.find(" ");
  string str, str_result;
  while (index != -1) {
    str = s.substr(0, index);
    cout << str << endl;
    s = s.substr(index + 1);
    reverse(str.begin(), str.end());
    str_result = str_result + str + " ";
    index = s.find(" ");
  }
  reverse(s.begin(), s.end());
  str_result += s;
  return str_result;
}

int main() {
  string s = "Let's take LeetCode contest";
  cout << reverseWords(s) << endl;
}
