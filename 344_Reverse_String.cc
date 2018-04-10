#include <iostream>
#include <string>
using namespace std;
string reverseString(string S) {
  string str;
  for (auto s : S) {
    str.insert(str.begin(), s);
  }
  return str;
}

int main() {
  string str1("hello");
  string str_result = reverseString(str1);
  cout << str_result << endl;
}
