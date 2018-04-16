#include <iostream>
#include <string>
int lengthOfLastWord(std::string s) {
  int len = 0; int tail = s.length() - 1;
  while (s[tail] == ' ' && tail >= 0) {
    tail--;
  }
  while (s[tail] != ' ' && tail >= 0) {
    len++;
    tail--;
  }
  return len;
}

int main() {
  std::string s("a ");
  std::cout << lengthOfLastWord(s) << std::endl;
}
