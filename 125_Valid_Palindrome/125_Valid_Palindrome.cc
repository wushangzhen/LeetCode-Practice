#include <iostream>
#include <string>
bool isAlphaNum(char& c);
bool isPalindrome(std::string s) {
  int left = 0, right = s.length() - 1;
  while (left < right) {
    if (!isAlphaNum(s[left])) {
      left++;
    } else if (!isAlphaNum(s[right])) {
      right--;
    } else if ((s[left] + 32 - 'a') % 32 != (s[right] + 32 - 'a') % 32) {
      return false;
    } else {
      left++;
      right--;
    }
    //std::cout << "111" << std::endl;
  }
  return true;
}

bool isAlphaNum(char& c) {
  if (c >= 'a' && c <= 'z') {
    return true;
  }
  if (c >= 'A' && c <= 'Z') {
    return true;
  }
  if (c >= '0' && c <= '9') {
    return true;
  }
  return false;
}
int main() {
  int a = 'a';
  int A = 'A';
  int z = 'z';
  int Z = 'Z';
  int test = '0';
  std::cout << a << "," << A << "," << test << std::endl;
  std::cout << z << "," << Z << std::endl;
  std::string s = "A man, a plan, a canal: Panam";
  std::cout << isPalindrome(s) << std::endl;
}

