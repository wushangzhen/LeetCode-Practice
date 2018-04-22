#include <iostream>

bool isPalindrome(int x) {
  if (x < 0) {
    return false;
  } 
  int temp = x;
  int digit = 0;
  int result = 0;
  while (temp != 0) {
   digit = temp % 10;
   result *= 10;
   result += digit;
   temp = temp / 10;
  }
  if (result == x) {
    return true;
  } else {
    return false;
  }
}

int main() {
  int input1 = 2;
  std::cout << isPalindrome(input1) << std::endl;
}
