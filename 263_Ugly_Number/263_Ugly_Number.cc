#include <iostream>

bool isUgly(int num) {
  if (num == 0) {
    return false;
  }
  if (num == 1) {
    return true;
  }
  while (num % 2 == 0) {
    num /= 2;
  }
  if (num == 1) {
    return true;
  }
  while (num % 3 == 0) {
    num /= 3;
  }
  if (num == 1) {
    return true;
  }
  while (num % 5 == 0) {
    num /= 5;
  }
  if (num == 1) {
    return true;
  }
  return false;
}
bool isUgly2() { // this is a more concise method using the same logic
  for (int i=2; i<6 && num; i++)
      while (num % i == 0)
          num /= i;
  return num == 1;
}
int main() {
  std::cout << isUgly(2) << std::endl;
  std::cout << isUgly(6) << std::endl;
  std::cout << isUgly(14) << std::endl;
}
