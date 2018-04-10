#include <string>
#include <iostream>
using namespace std;
string reverseStr(string s, int k) {
  int i = 0;
  int j = 0;

  if (s.size() < k) {
    reverse(s.begin(), s.end());
  }
  else if (k <= s.size() && s.size() < 2 * k) {
    reverse(s.begin(), s.begin() + k);
  }
  else if (2 * k <= s.size()) {
    i = s.size() / (2 * k);
    j = s.size() % (2 * k);
    for (int count = 0; count < i; count++) {
      reverse(s.begin() + count * 2 * k, s.begin() + count * 2 * k + k);
    }

    if (j < k) {
      reverse(s.begin() + i * 2 * k, s.end());
    }
    if (k <= j && j < 2 * k) {
      reverse(s.begin() + i * 2 * k, s.begin() + i * 2 * k + k);
    }
  }
  return s;
}

int main() {
  string s = "abcdefghijk";
  cout << s << endl;
  cout << reverseStr(s, 2) << endl;
}
